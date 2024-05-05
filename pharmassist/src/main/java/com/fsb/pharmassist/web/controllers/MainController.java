package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index")
    public String showHomePage() {
        return "index";
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
