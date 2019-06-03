package com.feeleen.sstuMath.controllers;

import com.feeleen.sstuMath.repositories.RsaCustomMessage;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;

@Controller
public class RsaCustomEncryption {

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
        int e = 1;

        //todo add random
        while (true) {
            if ((e * d) % ((p - 1) * (q - 1)) == 1) {
                return e;
            } else {
                e++;
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
//        while (true) {
//            Random rnd = new Random();
//            int i = rnd.nextInt(temp);
//            if (temp % i != 0) {
//                return i;
//            }
//        }

        throw new Exception();
    }
}



    