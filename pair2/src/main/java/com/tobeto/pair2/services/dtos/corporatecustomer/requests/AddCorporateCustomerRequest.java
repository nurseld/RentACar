package com.tobeto.pair2.services.dtos.corporatecustomer.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCorporateCustomerRequest {

    @NotBlank(message = "Company name cannot be blank")
    @Size(min = 2, message = "Company name cannot be less than 2 characters")
    private String companyName;

    @Pattern(regexp = "\\d{10}", message = "Tax number must be 10 digits")
    private String taxNo;

    @NotBlank(message = "Contact name cannot be blank")
    private String contactName;

    @Pattern(regexp = "^\\(\\d{3}\\) \\d{3} \\d{2} \\d{2}$", message = "Phone number must be in international format")
    private String phoneNumber;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @Positive(message = "UserId should be a greater than 0.")
    private int userId;
}
