package com.fsb.pharmassist.dao.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.pharmassist.dao.entities.MedicalProduct;

@Repository
public interface MedicalProductRepository extends JpaRepository<MedicalProduct, Long> {
    Optional<MedicalProduct> findById(Long id);

    List<MedicalProduct> findByMedicineNameContainingIgnoreCase(String name); // Recherche insensible à la casse

}