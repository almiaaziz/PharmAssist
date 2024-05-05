package com.fsb.pharmassist.business.services;

import java.util.List;

import com.fsb.pharmassist.dao.entities.MedicalProduct;
import com.fsb.pharmassist.web.dto.MedicalProductRegistrationDto;

public interface MedicalProductService {
    MedicalProduct save(MedicalProductRegistrationDto registrationDto);

    List<MedicalProduct> getAllMedicalProducts();

    void deleteMedicalProductById(Long id);
}
