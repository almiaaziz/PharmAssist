package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/browse-pharmacies")
    public String showPharmaciesPage() {
        return "browse-pharmacies";
    }

    @GetMapping("/browse-mp")
    public String showMedicalProductsPage() {
        return "browse-mp";
    }
}
