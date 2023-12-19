package com.tobeto.pair2.controllers;


import com.tobeto.pair2.services.abstracts.UserService;
import com.tobeto.pair2.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair2.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair2.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.pair2.services.dtos.user.responses.GetByIdUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersControllers {

    private final UserService userService;

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
}
