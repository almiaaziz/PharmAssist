package com.fsb.pharmassist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicalProductRegistrationDto {

    private String medicineName;
    private String composition;
    private String uses;
    private String manufacturer;
    private String quantity;

    public MedicalProductRegistrationDto() {
    }

}
