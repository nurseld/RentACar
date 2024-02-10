package com.tobeto.pair2.services.dtos.customer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCustomerRequest {


    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalIdNo;
    private LocalDate birthDate;
    private String phoneNumber;
    private int userId;

}
