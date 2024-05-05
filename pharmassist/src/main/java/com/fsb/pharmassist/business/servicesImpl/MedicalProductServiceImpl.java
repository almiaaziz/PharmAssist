package com.fsb.pharmassist.business.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.pharmassist.business.services.MedicalProductService;
import com.fsb.pharmassist.dao.entities.MedicalProduct;
import com.fsb.pharmassist.dao.repositories.MedicalProductRepository;
import com.fsb.pharmassist.web.dto.MedicalProductRegistrationDto;

@Service
public class MedicalProductServiceImpl implements MedicalProductService {

    @Autowired
    private MedicalProductRepository mpRepository;

    @Autowired
    public MedicalProductServiceImpl(MedicalProductRepository mpRepository) {
        this.mpRepository = mpRepository;
    }

    @Override
    public MedicalProduct save(MedicalProductRegistrationDto registrationDto) {
        MedicalProduct mp = new MedicalProduct(registrationDto.getMedicineName(), registrationDto.getComposition(),
                registrationDto.getUses(), registrationDto.getManufacturer(), registrationDto.getQuantity());
        return mpRepository.save(mp);
    }

    @Override
    public List<MedicalProduct> getAllMedicalProducts() {
        return mpRepository.findAll();
    }

    public static List<MedicalProduct> getAllMedicalProductsStatic() {
        // Implementation for static method
        return null;
    }
}
