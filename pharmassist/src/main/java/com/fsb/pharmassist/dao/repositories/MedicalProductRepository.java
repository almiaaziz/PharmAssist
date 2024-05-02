package com.fsb.pharmassist.dao.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.pharmassist.dao.entities.MedicalProduct;

@Repository
public interface MedicalProductRepository extends JpaRepository<MedicalProduct, Long> {
    static MedicalProduct findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
}