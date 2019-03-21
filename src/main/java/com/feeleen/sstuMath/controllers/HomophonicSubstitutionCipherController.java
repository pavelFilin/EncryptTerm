package com.feeleen.EncryptTermSite.controllers;

import com.feeleen.EncryptTermSite.services.HomophonicSubstitutionCipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Encrypts/HomophonicSubstitutionCipher")
public class HomophonicSubstitutionCipherController {
    @Autowired
    private HomophonicSubstitutionCipherService homophonicSubstitutionCipherService;

    @GetMapping
    public String getHomophonicSubstitutionCipher() {
        return "HomophonicSubstitutionCipher";
    }

    @PostMapping
    public String encrypt(@RequestParam String text, Model model) throws Exception {
        Map<Character, Double> frequencies = homophonicSubstitutionCipherService.getFrequencies(text);
        Map<Character, List<Integer>> keys = homophonicSubstitutionCipherService.getKeys(text, frequencies);
        model.addAttribute("keys", keys);
        String encryptMessage = homophonicSubstitutionCipherService.encryptByKey(text, keys);
        model.addAttribute("message", text);
        model.addAttribute("encryptMessage", encryptMessage);
        return "HomophonicSubstitutionCipher";
    }
}
