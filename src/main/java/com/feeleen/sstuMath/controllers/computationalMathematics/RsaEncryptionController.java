package com.feeleen.sstuMath.controllers.computationalMathematics;

import com.feeleen.sstuMath.configs.RsaEncryption;
import com.feeleen.sstuMath.repositories.RsaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RsaEncryptionController {
    @Autowired
    private RsaEncryption rsaEncryption;

    private List<RsaMessage> rsaMessages = new ArrayList<>();

    @GetMapping("/RsaEncryption")
    public String getPage(Model model) {
        model.addAttribute("massages", rsaMessages);
        return "RcaEncryption";
    }

    @PostMapping("/RsaEncryption")
    public String addMessage(@RequestParam String message, Model model) {



        return "redirect:" + "/RsaEncryption";
    }
}
