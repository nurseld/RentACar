package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.AuthService;
import com.tobeto.pair2.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.pair2.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair2.services.dtos.user.requests.LoginRequest;
import com.tobeto.pair2.services.dtos.user.responses.AuthResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("individual")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody AddCustomerRequest request) {
        authService.register(request);
    }
}
