package com.fsb.pharmassist.business.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.pharmassist.business.services.PharmacistService;
import com.fsb.pharmassist.dao.entities.Pharmacist;
import com.fsb.pharmassist.dao.entities.Pharmacy;
import com.fsb.pharmassist.dao.repositories.PharmacistRepository;
import com.fsb.pharmassist.dao.repositories.PharmacyRepository;
import com.fsb.pharmassist.web.dto.PharmacistRegistrationDto;

import jakarta.transaction.Transactional;

@Service
public class PharmacistServiceImpl implements PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Override
    @Transactional
    public void savePharmacist(PharmacistRegistrationDto registrationDto) {

        Pharmacy pharmacy = new Pharmacy(registrationDto.getPharmacyName(), registrationDto.getCity(),
                registrationDto.getZipCode(),
                registrationDto.getLatitude(), registrationDto.getLongitude());

        Pharmacist pharmacist = new Pharmacist(registrationDto.getFirstName(), registrationDto.getLastName(),
                registrationDto.getUsername(),
                registrationDto.getEmail(), registrationDto.getPassword());

        pharmacy.setPharmacist(pharmacist);
        pharmacyRepository.save(pharmacy);
        pharmacistRepository.save(pharmacist);
    }
}