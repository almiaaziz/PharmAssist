package com.fsb.pharmassist.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.pharmassist.dao.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    Client findByEmail(String email);

    Client findByUsername(String username);
}