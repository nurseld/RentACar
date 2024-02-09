package com.tobeto.pair2.services.dtos.corporatecustomer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCorporateCustomerResponse {

    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalIdNo;
    private LocalDate birthDate;
    private String phoneNumber;
    private int userId;
}
