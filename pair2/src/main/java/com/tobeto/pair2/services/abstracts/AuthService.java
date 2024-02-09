package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.pair2.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair2.services.dtos.user.requests.LoginRequest;
import com.tobeto.pair2.services.dtos.user.responses.AuthResponse;

public interface AuthService {
    void register(CreateUserRequest createUserRequest);
    String login(LoginRequest loginRequest);
    void register(AddCorporateCustomerRequest addCustomerRequest);
    AuthResponse login(LoginRequest loginRequest);

}
