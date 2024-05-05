package com.fsb.pharmassist.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsb.pharmassist.business.services.PharmacyService;
import com.fsb.pharmassist.dao.entities.Pharmacy;

import java.util.List;

@Controller
@RequestMapping("/browse-pharmacies")
public class PharmacyController {

    private final PharmacyService pharmacyService;

    @Autowired
    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping
    public String getAllPharmacies(Model model) {
        List<Pharmacy> pharmacies = pharmacyService.getAllPharmacies();
        model.addAttribute("pharmacies", pharmacies);
        return "browse-pharmacies"; // Assuming "pharmacies.html" is your view template
    }
}
