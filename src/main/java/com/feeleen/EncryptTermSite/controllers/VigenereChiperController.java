package com.feeleen.EncryptTermSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Encrypts/VigenereChiper")
public class VigenereChiperController {
    @GetMapping
    public String getVigenereChiper() {
        return "VigenereChiper";
    }

    @PostMapping
    public String encryptMassage(@RequestParam String text, @RequestParam String key, Model model) {
        return "VigenereChiper";
    }
}
