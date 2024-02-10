package com.tobeto.pair2.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalIdNo;
    private String birthDate;
    private String phoneNumber;

}
