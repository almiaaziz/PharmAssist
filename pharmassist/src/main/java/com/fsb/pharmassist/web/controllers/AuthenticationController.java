package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fsb.pharmassist.dao.entities.Client;

@Controller
public class AuthenticationController {
    

    @GetMapping("/register-client")
    public String showCustomRegisterClienttPage(Model model) {
        model.addAttribute("client", new Client());
        return "register-client";
    }

    @GetMapping("/register-pharmacist")
    public String showCustomRegisterPharmacistPage() {
        return "register-pharmacist";
    }

}
