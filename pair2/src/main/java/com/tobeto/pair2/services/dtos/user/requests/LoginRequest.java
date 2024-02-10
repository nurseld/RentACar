package com.tobeto.pair2.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {

    private String email;
    private String password;
}