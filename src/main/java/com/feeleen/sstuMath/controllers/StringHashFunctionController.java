package com.feeleen.EncryptTermSite.controllers;

import com.feeleen.EncryptTermSite.services.StringHashFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StringHashFunctionController {
    @Autowired
    private StringHashFunctionService stringHashFunctionService;

    @GetMapping("/StringHashCodeExample")
    public String getHashCode(@RequestParam(required = false) String s, Model model) {
        if (!StringUtils.isEmpty(s)) {
            int hash = stringHashFunctionService.hashCode(s);
            String hashText = hash + "";
            while (hashText.length() < 10) {
                hashText = "0" + hashText;
            }

            model.addAttribute("hashCode", hashText);
            model.addAttribute("message", s);
        }

        return "StringHashFunction";

    }
}
