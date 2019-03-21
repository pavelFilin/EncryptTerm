package com.feeleen.EncryptTermSite.controllers;

import com.feeleen.EncryptTermSite.services.HomophonicSubstitutionCipherService;
import com.feeleen.EncryptTermSite.services.TranspositionСipherService;
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
@RequestMapping("/Encrypts/CombinationCipher")
public class CombinationMethodController {
    @Autowired
    private TranspositionСipherService transpositionСipherService;

    @Autowired
    private HomophonicSubstitutionCipherService homophonicSubstitutionCipherService;

    @GetMapping
    public String getConbinationMethodController() {
        return "CombinationCipher";
    }

    @PostMapping
    public String encrypt(@RequestParam String text, @RequestParam int shift, Model model) throws Exception {
        String s = transpositionСipherService.encryptMessage(text, shift);
        Map<Character, Double> frequencies = homophonicSubstitutionCipherService.getFrequencies(s);
        Map<Character, List<Integer>> keys = homophonicSubstitutionCipherService.getKeys(s, frequencies);
        String encryptMessage = homophonicSubstitutionCipherService.encryptByKey(text, keys);
        model.addAttribute("message", text);
        model.addAttribute("keys", keys);
        model.addAttribute("prepMessage", s);
        model.addAttribute("encryptMessage", encryptMessage);
        return "CombinationCipher";
    }
}
