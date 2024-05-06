package com.fsb.pharmassist.business.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fsb.pharmassist.dao.entities.Client;
import com.fsb.pharmassist.dao.entities.Pharmacist;
import com.fsb.pharmassist.dao.repositories.ClientRepository;
import com.fsb.pharmassist.dao.repositories.PharmacistRepository;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Vérifiez si le client existe
        Client client = clientRepository.findByUsername(username);
        if (client != null) {
            return new org.springframework.security.core.userdetails.User(
                    client.getEmail(),
                    client.getPassword(), // mot de passe non encodé
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_CLIENT")));
        }

        // Vérifiez si le pharmacien existe
        Pharmacist pharmacist = pharmacistRepository.findByUsername(username);
        if (pharmacist != null) {
            return new org.springframework.security.core.userdetails.User(
                    pharmacist.getEmail(),
                    pharmacist.getPassword(), // mot de passe non encodé
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_PHARMACIST")));
        }

        throw new UsernameNotFoundException("User with the username : " + username + " NOT FOUND");
    }
}
