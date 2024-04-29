package com.fsb.pharmassist.web.dto;

import com.fsb.pharmassist.dao.entities.Pharmacy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PharmacistRegistrationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Pharmacy pharmacy;
}
