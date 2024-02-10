package com.tobeto.pair2.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String token;
    private int id;
    private String role;

}
