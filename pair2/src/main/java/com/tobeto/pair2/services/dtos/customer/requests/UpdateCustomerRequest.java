package com.tobeto.pair2.services.dtos.customer.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, message = "First name must be at least 2 characters long")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, message = "Last name must be at least 2 characters long")
    private String lastName;

    @Pattern(regexp = "\\d{11}", message = "National ID number must be 11 digits")
    private String nationalIdNo;

    private LocalDate birthDate;

    @Pattern(regexp = "^\\(\\d{3}\\) \\d{3} \\d{2} \\d{2}$", message = "Phone number must be in the format (###) ### ## ##")
    private String phoneNumber;

    @Positive(message = "UserId should be a greater than 0.")
    private int userId;
}
