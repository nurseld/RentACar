package com.tobeto.pair2.services.dtos.corporatecustomer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCorporateCustomerResponse {

    private Integer id;
    private String email;
    private String password;
    private String companyName;
    private String taxtNo;
    private String contactName;
    private String phoneNumber;
    private int userId;

}
