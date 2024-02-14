package com.tobeto.pair2.services.dtos.corporatecustomer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserIdCorporateCustomerResponse {
    private LocalDate createdDate;
    private Integer id;
    private String email;
    private String password;
    private String companyName;
    private String taxtNo;
    private String contactName;
    private String phoneNumber;
    private int userId;
}
