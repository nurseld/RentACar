package com.tobeto.pair2.services.dtos.model.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    @NotBlank
    @Size(min = 2, message = "The Model cannot be less than 2 characters.")
    private String name;
    private int brandId;

}
