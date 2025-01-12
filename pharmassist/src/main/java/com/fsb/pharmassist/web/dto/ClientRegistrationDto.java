package com.fsb.pharmassist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientRegistrationDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    public ClientRegistrationDto() {
        // TODO Auto-generated constructor stub
    }
}
