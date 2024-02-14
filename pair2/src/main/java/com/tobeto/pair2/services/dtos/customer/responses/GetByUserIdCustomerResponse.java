package com.tobeto.pair2.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserIdCustomerResponse {

    private LocalDate createdDate;

    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String nationalIdNo;

    private String phoneNumber;

    private Integer userId;

}
