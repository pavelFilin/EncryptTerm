package com.feeleen.EncryptTermSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EncryptMethods {
    @GetMapping("/Encrypts")
    public String getEncryptMethods() {
        return "EncryptMethods";
    }
}
