package com.tobeto.pair2.services.dtos.user.requests;

import com.tobeto.pair2.entitites.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
