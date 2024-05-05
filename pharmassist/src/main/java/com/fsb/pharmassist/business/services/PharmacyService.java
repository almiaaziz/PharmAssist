package com.fsb.pharmassist.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.pharmassist.dao.entities.Pharmacy;
import com.fsb.pharmassist.dao.repositories.PharmacyRepository;

import java.util.List;

@Service
public interface PharmacyService {
    List<Pharmacy> getAllPharmacies();
}
