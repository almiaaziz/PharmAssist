package com.fsb.pharmassist.business.services;

import com.fsb.pharmassist.dao.entities.Client;
import com.fsb.pharmassist.web.dto.ClientRegistrationDto;

public interface ClientService {
    Client save(ClientRegistrationDto registrationDto);
}