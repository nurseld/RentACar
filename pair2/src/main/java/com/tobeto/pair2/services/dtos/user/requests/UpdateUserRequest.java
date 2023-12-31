package com.tobeto.pair2.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private Integer id;

    private String name;

    private String surname;

    private String email;

    private LocalDate birthDate;

}
