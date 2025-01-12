package com.fsb.pharmassist.business.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.pharmassist.business.services.PharmacyService;
import com.fsb.pharmassist.dao.entities.Pharmacy;
import com.fsb.pharmassist.dao.repositories.PharmacyRepository;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyRepository.findAll();
    }

}