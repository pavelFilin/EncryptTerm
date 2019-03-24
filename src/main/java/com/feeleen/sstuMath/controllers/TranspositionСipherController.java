package com.feeleen.sstuMath.controllers;

import com.feeleen.sstuMath.services.TranspositionСipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("Encrypts/TranspositionCipher")
public class TranspositionСipherController {

    @Autowired
    private TranspositionСipherService transpositionСipherService;

    @GetMapping
    public String getTranspositionCipher() {
        return "TranspositionCipher";
    }

    @PostMapping
    public String enctyptMessage(@RequestParam String text, @RequestParam int shift, Model model) {
        String encryptMessage = transpositionСipherService.encryptMessage(text, shift);
        model.addAttribute("encryptMessage", encryptMessage);
        model.addAttribute("message", text);

        return "TranspositionCipher";
    }
}