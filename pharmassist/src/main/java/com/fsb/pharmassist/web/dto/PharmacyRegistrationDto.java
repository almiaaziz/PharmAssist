package com.fsb.pharmassist.web.dto;

import com.fsb.pharmassist.dao.entities.Pharmacist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PharmacyRegistrationDto {
    public PharmacyRegistrationDto(String pharmacyName, String city2, int zipCode2, String latitude2,
            String longitude2) {
        //TODO Auto-generated constructor stub
    }
    private Long id;
    private String name;
    private String city;
    private int zipCode;
    private String latitude;
    private String longitude;
    public void setPharmacist(Pharmacist pharmacist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPharmacist'");
    }
}
