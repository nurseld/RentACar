package com.tobeto.pair2.services.dtos.corporatecustomer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCorporateCustomerRequest {

    private String companyName;
    private String taxNo;
    private String contactName;
    private String phoneNumber;
    private String email;
    private String password;
    private int userId;
}
