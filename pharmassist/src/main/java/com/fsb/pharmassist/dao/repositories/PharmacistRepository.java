package com.fsb.pharmassist.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fsb.pharmassist.dao.entities.Pharmacist;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {

    Pharmacist findByUsername(String username);
}