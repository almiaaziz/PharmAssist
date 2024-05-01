package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fsb.pharmassist.dao.entities.Client;
import com.fsb.pharmassist.web.dto.PharmacistRegistrationDto;

@Controller
public class AuthenticationController {

    @GetMapping("/register-client")
    public String showCustomRegisterClienttPage(Model model) {
        model.addAttribute("client", new Client());
        return "register-client";
    }

    @GetMapping("/register-pharmacist")
    public String showCustomRegisterPharmacistPage(Model model) {
        model.addAttribute("pharmacist", new PharmacistRegistrationDto());
        return "register-pharmacist";
    }

}
