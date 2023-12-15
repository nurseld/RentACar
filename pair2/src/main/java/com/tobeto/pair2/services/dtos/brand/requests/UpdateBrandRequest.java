package com.tobeto.pair2.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class UpdateBrandRequest {
    @Positive
    private int id;
    @NotBlank
    @Size(min = 2, message = "The Brand cannot be less than 2 characters.")
    private String name;
}
