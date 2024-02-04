package com.tobeto.pair2.controllers;


import com.tobeto.pair2.core.services.JwtService;
import com.tobeto.pair2.services.abstracts.UserService;
import com.tobeto.pair2.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair2.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.pair2.services.dtos.user.requests.LoginRequest;
import com.tobeto.pair2.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair2.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.pair2.services.dtos.user.responses.GetByIdUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddUserRequest request) {
        userService.add(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateUserRequest request) {
        userService.update(request);
    }

    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdUserResponse getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody CreateUserRequest request){
        userService.register(request);
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(loginRequest.getUsername());
        }

        throw new RuntimeException("Kullanıcı adı ya da şifre yanlış");
    }
}
