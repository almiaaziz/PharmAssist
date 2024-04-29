package com.fsb.pharmassist.business.services;

import com.fsb.pharmassist.dao.entities.Pharmacist;
import com.fsb.pharmassist.web.dto.PharmacistRegistrationDto;

public interface PharmacistService {
    Pharmacist save(PharmacistRegistrationDto registrationDto);
}
