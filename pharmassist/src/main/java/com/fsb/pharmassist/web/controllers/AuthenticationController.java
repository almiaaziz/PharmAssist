package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showCustomLoginPage() {
        return "login";
    }

    @GetMapping("/register-pharmacist")
    public String showCustomRegisterPharmacistPage() {
        return "register-pharmacist";
    }

    @GetMapping("/register-client")
    public String showCustomRegisterClienttPage() {
        return "register-client";
    }
}
