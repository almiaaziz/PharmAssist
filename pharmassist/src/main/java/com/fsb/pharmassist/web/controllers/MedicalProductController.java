package com.fsb.pharmassist.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsb.pharmassist.dao.repositories.MedicalProductRepository;
import com.fsb.pharmassist.web.dto.MedicalProductRegistrationDto;
import com.fsb.pharmassist.business.services.MedicalProductService;
import com.fsb.pharmassist.dao.entities.MedicalProduct;

@Controller
public class MedicalProductController {
    @Autowired
    private MedicalProductRepository medicalProductRepository;

    @Autowired
    private MedicalProductService mpService;

    @GetMapping("/browse-mp")
    public String listMedicines(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size); // Utilisation de PageRequest

        Page<MedicalProduct> medicinesPage = medicalProductRepository.findAll(pageable); // Pagination
        medicinesPage.get();

        model.addAttribute("medicinesPage", medicinesPage);

        return "browse-mp"; // Retourne la page de navigation des médicaments
    }

    @GetMapping("/medicine-details/{id}")
    public String getMedicineDetails(@PathVariable Long id, Model model) {
        MedicalProduct medicine = medicalProductRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid medicine ID: " + id)); // Gestion des erreurs
        model.addAttribute("medicine", medicine);
        return "medicine-details"; // Correction du nom de la page
    }

    @GetMapping("/search-medicines")
    public String searchMedicines(
            @RequestParam String searchQuery,
            Model model) {
        // Effectuer une recherche basée sur le nom du médicament ou d'autres critères
        List<MedicalProduct> foundMedicines = medicalProductRepository
                .findByMedicineNameContainingIgnoreCase(searchQuery);

        model.addAttribute("foundMedicines", foundMedicines);
        model.addAttribute("searchQuery", searchQuery);

        return "search-results"; // Nom de la page de résultats de recherche
    }

    /////////////////////////////
    @ModelAttribute("medicine")
    public MedicalProductRegistrationDto mpRegistrationDto() {
        return new MedicalProductRegistrationDto();
    }

    @PostMapping("/add-mp")
    public String registerMP(@ModelAttribute("medicine") MedicalProductRegistrationDto registrationDto,
            RedirectAttributes redirectAttributes) {
        mpService.save(registrationDto);
        redirectAttributes.addFlashAttribute("successMessage", "Medicine added successfully!");
        return "redirect:/inventory";
    }

    // Delete a medicine
    @GetMapping("/{id}/delete")
    public String deleteMedicine(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        mpService.deleteMedicalProductById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Medicine deleted successfully!");
        return "redirect:/inventory";
    }

}
