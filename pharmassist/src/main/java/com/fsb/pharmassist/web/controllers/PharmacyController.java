package com.fsb.pharmassist.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsb.pharmassist.business.services.PharmacyService;

import java.util.List;

@Controller
@RequestMapping("/browse-pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping
    public String browsePharmacies(Model model) {
        List<com.fsb.pharmassist.dao.entities.Pharmacy> pharmacies = pharmacyService.getAllPharmacies(); // Update the type here
        model.addAttribute("pharmacies", pharmacies);
        return "browse-pharmacies"; // Thymeleaf template name
    }
}
