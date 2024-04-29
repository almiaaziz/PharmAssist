package com.fsb.pharmassist.business.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.pharmassist.business.services.ClientService;
import com.fsb.pharmassist.dao.entities.Client;
import com.fsb.pharmassist.dao.repositories.ClientRepository;
import com.fsb.pharmassist.web.dto.ClientRegistrationDto;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(ClientRegistrationDto registrationDto) {
        Client client = new Client(registrationDto.getFirstName(), registrationDto.getLastName(),
        registrationDto.getUsername(),registrationDto.getEmail(), registrationDto.getPassword());
        return clientRepository.save(client);
    }
}
