package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.services.JwtService;
import com.tobeto.pair2.entitites.concretes.Role;
import com.tobeto.pair2.entitites.concretes.User;
import com.tobeto.pair2.services.abstracts.AuthService;
import com.tobeto.pair2.services.abstracts.CorporateCustomerService;
import com.tobeto.pair2.services.abstracts.CustomerService;
import com.tobeto.pair2.services.abstracts.UserService;
import com.tobeto.pair2.services.dtos.corporatecustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair2.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair2.services.dtos.user.requests.LoginRequest;
import com.tobeto.pair2.services.dtos.user.responses.AuthResponse;
import com.tobeto.pair2.services.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomerService customerService;
    private final CorporateCustomerService corporateCustomerService;
    private final UserBusinessRules userBusinessRules;
    @Override
    public void register(AddCustomerRequest addCustomerRequest) {

        this.userBusinessRules.checkIfEmailExists(addCustomerRequest.getEmail());

        User user = User.builder()
                .email(addCustomerRequest.getEmail())
                .authorities(List.of(Role.USER))
                .password(passwordEncoder.encode(addCustomerRequest.getPassword()))
                .build();
        Integer createdUserId = userService.add(user);

        addCustomerRequest.setUserId(createdUserId);

        customerService.add(addCustomerRequest);
    }

    @Override
    public void register(AddCorporateCustomerRequest addCorporateCustomerRequest) {



        User user = User.builder()
                .email(addCorporateCustomerRequest.getEmail())
                .authorities(List.of(Role.USER))
                .password(passwordEncoder.encode(addCorporateCustomerRequest.getPassword()))
                .build();

        Integer createdUserId = userService.add(user);
        addCorporateCustomerRequest.setUserId(createdUserId);
        corporateCustomerService.add(addCorporateCustomerRequest);

    }


    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        AuthResponse response = new AuthResponse();
        if(authentication.isAuthenticated())
        {
            response.setToken(jwtService.generateToken(loginRequest.getEmail()));
            User user =  userService.findByEmail(loginRequest.getEmail());
            response.setId(user.getId());
            response.setRole(user.getAuthorities().get(0).name());
            return response;
        }

        throw new RuntimeException("Kullanıcı adı ya da şifre yanlış");
    }

}
