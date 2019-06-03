package com.feeleen.sstuMath.controllers;

import com.feeleen.sstuMath.repositories.RsaCustomMessage;
import com.feeleen.sstuMath.repositories.RsaMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/Encrypts/CustomRSA")
public class RsaCustomEncryption {

    List<RsaCustomMessage> rsaMessages = new ArrayList<>();

    public RsaCustomMessage encrypt(String text) throws Exception {
        int p = 43;
        int q = 47;
        int n = p * q;
        int d = getD(p, q);
        int e = getE(d, p, q);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            BigInteger bigChar = new BigInteger(Integer.toString(text.charAt(i)));
            BigInteger bigD = new BigInteger(Integer.toString(d));
            BigInteger bigN = new BigInteger(Integer.toString(n));
            BigInteger enc = bigChar.modPow(bigD, bigN);
            stringBuilder.append((char) enc.intValue());
        }


        return new RsaCustomMessage(p, q, n, d, e, text, stringBuilder.toString());
    }

    public String decrypt(int e, int n, String encryptText) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encryptText.length(); i++) {
            BigInteger bigChar = new BigInteger(Integer.toString(encryptText.charAt(i)));
            BigInteger bigE = new BigInteger(Integer.toString(e));
            BigInteger bigN = new BigInteger(Integer.toString(n));
            BigInteger enc = bigChar.modPow(bigE, bigN);
            result.append((char) enc.intValue());
        }

        return result.toString();
    }

    private int getE(int d, int p, int q) {
        int e = 2;

        BigInteger bigE = BigInteger.valueOf(e);
        BigInteger bigD = BigInteger.valueOf(d);
        BigInteger bigP = BigInteger.valueOf(p);
        BigInteger bigQ = BigInteger.valueOf(q);
        //todo add random
        while (true) {

//            int test = (p - 1) * (q - 1);
            BigInteger temp1 = bigP.subtract(BigInteger.ONE);
            BigInteger temp2 = bigQ.subtract(BigInteger.ONE);
            BigInteger bigRight = temp1.multiply(temp2);
            BigInteger bigL = bigE.multiply(bigD);

            if (bigL.mod(bigRight).intValue() == 1 && bigE.intValue() != bigD.intValue()) {
                return bigE.intValue();
            } else {
                System.out.println(bigE.intValue());
                bigE = bigE.add(BigInteger.ONE);

            }
        }
    }


    private int getD(int p, int q) throws Exception {
        int temp = (p - 1) * (q - 1);

        for (int i = temp - 1; i > 1; i--) {
            if (temp % i != 0) {
                return i;
            }
        }


        //todo use random
//        Random rnd = new Random();
//        while (true) {
//            int i = rnd.nextInt(temp);
//            System.out.println(i);
//            if (temp % i != 0) {
//                return i;
//            }
//        }

        throw new Exception();
    }


    @GetMapping("messages")
    @ResponseBody
    public List<RsaCustomMessage> getMessages(Model model) {
        return rsaMessages;
    }

    @GetMapping("messages/{id}")
    @ResponseBody
    public RsaCustomMessage getMessage(@PathVariable(name = "id") Long id) {
        return rsaMessages.get(0);
    }

    @PostMapping("addMessage")
    @ResponseBody
    public void addMessage(@RequestParam String message) throws Exception {
        RsaCustomMessage encryptMessage = encrypt(message);
        rsaMessages.add(encryptMessage);
    }
}



    