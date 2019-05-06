package com.feeleen.sstuMath.controllers;

import com.feeleen.sstuMath.configs.RsaEncryption;
import com.feeleen.sstuMath.repositories.RsaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Encrypts/RsaEncryption")
public class RsaEncryptionController {
    @Autowired
    private RsaEncryption rsaEncryption;

    private List<RsaMessage> rsaMessages = new ArrayList<>();

    private Long rsaMessageId = 0L;

    @GetMapping
    public String getPage() {
        return "RcaEncryption";
    }

    @GetMapping("messages")
    @ResponseBody
    public List<RsaMessage> getMessages(Model model) {
        return rsaMessages;
    }

    @GetMapping("messages/{id}")
    @ResponseBody
    public RsaMessage getMessage(@PathVariable(name = "id") Long id) {
        return rsaMessages.stream().filter(s -> s.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping("addMessage")
    @ResponseBody
    public void addMessage(@RequestParam String message) throws Exception {
        RsaMessage rsaMessage = new RsaMessage();
        rsaMessage.setMessage(message);

        rsaEncryption.buildKeyPair();

        rsaMessage.setMessage(message);
        rsaMessage.setPrivateKey(rsaEncryption.getPrivateKey());
        rsaMessage.setPublicKey(rsaEncryption.getPubKey());

        String signature = "filin@" + message.hashCode();

        rsaEncryption.encrypt(rsaEncryption.getPrivateKey(), signature);
        rsaMessage.setSignature(signature);
        rsaMessages.add(rsaMessage);
        rsaMessage.setId(rsaMessageId);
        rsaMessageId++;
    }
}
