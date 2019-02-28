package com.feeleen.EncryptTermSite.controllers;
import com.feeleen.EncryptTermSite.services.HomophonicSubstitutionCipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String encrypt(@RequestParam String text, Model model) {
        homophonicSubstitutionCipherService.getFrequencies(text);
        return "HomophonicSubstitutionCipher";
    }
}
