package com.fsb.pharmassist.business.services;

import com.fsb.pharmassist.web.dto.PharmacistRegistrationDto;

public interface PharmacistService {
    void savePharmacist(PharmacistRegistrationDto registrationDto);
}
