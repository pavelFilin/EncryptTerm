package com.feeleen.EncryptTermSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Encrypts")
public class VigenereChiperController {
    @GetMapping("VigenereChiper")
    public String getVigenereChiper() {
        return "VigenereChiper";
    }
}
