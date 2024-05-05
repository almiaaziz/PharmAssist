package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboardPage() {
        return "dashboard";
    }

    @GetMapping("/inventory")
    public String showInventoryPage() {
        return "inventory";
    }

    @GetMapping("/add-mp")
    public String showAddMedicalProductPage() {
        return "add-mp";
    }
}