package com.fsb.pharmassist.business.services;

import org.springframework.stereotype.Service;
import com.fsb.pharmassist.dao.entities.Pharmacy;

import java.util.List;

@Service
public interface PharmacyService {
    List<Pharmacy> getAllPharmacies();
}
