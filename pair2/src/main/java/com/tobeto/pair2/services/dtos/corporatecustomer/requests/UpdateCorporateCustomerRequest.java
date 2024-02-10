package com.tobeto.pair2.services.dtos.corporatecustomer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateCustomerRequest {

    private String companyName;
    private String taxNo;
    private String contactName;
    private String phoneNumber;
    private String email;
    private String password;

}
