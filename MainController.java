package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("/services")
    public String showServicesPage() {
        return "services";
    }
    @GetMapping("/mission")
    public String showMissonPage() {
        return "mission";
    }
    @GetMapping("/team")
    public String showTeamPage() {
        return "team";
    }
    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }

    /*
     * @GetMapping("/browse-mp")
     * public String showMedicalProductsPage() {
     * return "browse-mp";
     * }
     */

    @GetMapping("/404")
    public String showErrorPage() {
        return "404";
    }

    @GetMapping("/login")
    public String showCustomLoginPage(Model model) {
        if (model.containsAttribute("successMessage")) {
            model.addAttribute("successMessage", model.getAttribute("successMessage"));
        }
        return "login";
    }
}
