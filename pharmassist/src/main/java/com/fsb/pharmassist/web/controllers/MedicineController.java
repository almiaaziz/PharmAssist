package com.fsb.pharmassist.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsb.pharmassist.dao.repositories.MedicalProductRepository;
import com.fsb.pharmassist.dao.entities.MedicalProduct;

@Controller
public class MedicineController {
    @Autowired
    private MedicalProductRepository medicineRepository;

    @GetMapping("/browse-mp")
    public String listMedicines(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model, @PathVariable Long id) {
        Pageable pageable = PageRequest.of(page, size); // Utilisation de PageRequest

        Page<MedicalProduct> medicinesPage = medicine.findAll(pageable); // Pagination

        model.addAttribute("medicinesPage", medicinesPage);
        MedicalProduct medicine = MedicalProductRepository.findById(id);
        model.addAttribute("medicine", medicine); // Ajout de la page des médicaments

        return "browse-mp"; // Retourne la page de navigation des médicaments
    }

    @GetMapping("/medicine-details/{id}")
    public String getMedicineDetails(@PathVariable Long id, Model model) {
        MedicalProduct medicine = MedicalProductRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid medicine ID: " + id)); // Gestion des erreurs
        model.addAttribute("medicine", medicine);
        return "medicine-details"; // Correction du nom de la page
    }
}