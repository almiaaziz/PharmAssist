package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsb.pharmassist.business.services.PharmacistService;
import com.fsb.pharmassist.web.dto.PharmacistRegistrationDto;

@Controller
@RequestMapping("/register-pharmacist")
public class PharmacistRegistrationController {

    private PharmacistService pharmacistService;

    public PharmacistRegistrationController(PharmacistService pharmacistService) {
        super();
        this.pharmacistService = pharmacistService;
    }

    @ModelAttribute("pharmacist")
    public PharmacistRegistrationDto pharmacsitRegistrationDto() {
        return new PharmacistRegistrationDto();
    }

    @PostMapping
    public String registerPharmacistAccount(@ModelAttribute PharmacistRegistrationDto registrationDto,
            RedirectAttributes redirectAttributes) {
        pharmacistService.savePharmacist(registrationDto);
        redirectAttributes.addFlashAttribute("successMessage", "You've successfully registered!");
        return "redirect:/login";
    }
}
