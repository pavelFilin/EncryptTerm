package com.feeleen.sstuMath.controllers;

import com.feeleen.sstuMath.services.VigenereCipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Encrypts/VigenereChiper")
public class VigenereCipherController {
    @Autowired
    VigenereCipherService vigenereCipherService;

    @GetMapping
    public String getVigenereChiper() {
        return "VigenereCipher";
    }

    @PostMapping
    public String encryptMassage(@RequestParam String text, @RequestParam String keys, Model model) {
        String encryptMessage = vigenereCipherService.encryptMessage(text, keys);
        model.addAttribute("encryptMessage", encryptMessage);
        model.addAttribute("message", text);
        return "VigenereCipher";
    }
}
