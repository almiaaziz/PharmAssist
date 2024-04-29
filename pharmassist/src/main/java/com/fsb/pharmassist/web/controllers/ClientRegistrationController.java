package com.fsb.pharmassist.web.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsb.pharmassist.business.services.ClientService;
import com.fsb.pharmassist.web.dto.ClientRegistrationDto;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/register-client")
public class ClientRegistrationController {

    private ClientService clientService;

    public ClientRegistrationController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }

    @ModelAttribute("client")
    public ClientRegistrationDto clientRegistrationDto() {
        return new ClientRegistrationDto();
    }

    @PostMapping
    public String registerClientAccount(@ModelAttribute("Client") ClientRegistrationDto registrationDto,
            RedirectAttributes redirectAttributes) {
        clientService.save(registrationDto);
        redirectAttributes.addFlashAttribute("successMessage", "You've successfully registered!");
        return "redirect:/login";
    }
}
