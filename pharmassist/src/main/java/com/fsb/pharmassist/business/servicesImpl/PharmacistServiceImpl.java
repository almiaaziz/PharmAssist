package com.fsb.pharmassist.business.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.pharmassist.business.services.PharmacistService;
import com.fsb.pharmassist.dao.entities.Pharmacist;
import com.fsb.pharmassist.dao.entities.Pharmacy;
import com.fsb.pharmassist.dao.repositories.PharmacistRepository;
import com.fsb.pharmassist.web.dto.PharmacistRegistrationDto;

@Service
public class PharmacistServiceImpl implements PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Override
    public Pharmacist save(PharmacistRegistrationDto pharmacistDto) {
        // 1. Create Pharmacist object
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setFirstName(pharmacistDto.getFirstName());
        pharmacist.setLastName(pharmacistDto.getLastName());
        pharmacist.setUsername(pharmacistDto.getUsername());
        pharmacist.setEmail(pharmacistDto.getEmail());
        pharmacist.setPassword(pharmacistDto.getPassword());

        // 2. Set pharmacy on Pharmacist (assuming OneToMany relationship)
        pharmacist.setPharmacy(pharmacistDto.getPharmacy());

        // 3. Save Pharmacist (cascades to Pharmacy save)
        return pharmacistRepository.save(pharmacist);
    }
}