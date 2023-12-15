package com.tobeto.pair2.services.dtos.color.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddColorRequest {

    @NotBlank
    @Size(min = 2, message = "Color length can not be less than 2 characters.")
    private String name;
}
