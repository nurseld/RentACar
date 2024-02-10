package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.corporatecustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair2.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair2.services.dtos.user.requests.LoginRequest;
import com.tobeto.pair2.services.dtos.user.responses.AuthResponse;

public interface AuthService {
    void register(AddCustomerRequest addCustomerRequest);
    void register(AddCorporateCustomerRequest addCustomerRequest);
    AuthResponse login(LoginRequest loginRequest);


}
