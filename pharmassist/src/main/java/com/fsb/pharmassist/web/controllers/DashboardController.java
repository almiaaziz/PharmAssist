package com.fsb.pharmassist.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fsb.pharmassist.business.services.MedicalProductService;
import com.fsb.pharmassist.dao.entities.MedicalProduct;
import com.fsb.pharmassist.web.dto.MedicalProductRegistrationDto;

import org.springframework.ui.Model;

@Controller
public class DashboardController {

    @Autowired
    private MedicalProductService medicalProductService;

    @GetMapping("/dashboard")
    public String showDashboardPage() {
        return "dashboard";
    }

    @GetMapping("/inventory")
    public String showInventoryPage(Model model) {
        Iterable<MedicalProduct> medicines = medicalProductService.getAllMedicalProducts();

        // Add the fetched medicines to the model
        model.addAttribute("medicines", medicines);

        // Return the name of the HTML template to render
        return "inventory";
    }

    @GetMapping("/add-mp")
    public String showAddMedicalProductPage(Model model) {
        model.addAttribute("medicine", new MedicalProductRegistrationDto());
        return "add-mp";
    }
}