package com.fsb.pharmassist.web.dto;

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
    public Long idPharmacy;
    private String pharmacyName;
    private String city;
    private int zipCode;
    private String latitude;
    private String longitude;
    
    public PharmacistRegistrationDto(String firstName, String lastName, String username, String email, String password,
            String pharmacyName, String city, int zipCode, String latitude, String longitude) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.pharmacyName = pharmacyName;
        this.city = city;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PharmacistRegistrationDto(String firstName, String lastName, String username, String email, String password,
            Long idPharmacy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.idPharmacy = idPharmacy;
    }

}
