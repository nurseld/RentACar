package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.entitites.concretes.User;
import com.tobeto.pair2.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair2.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair2.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.pair2.services.dtos.user.responses.GetByIdUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean existsByUserId(int userId);
    void add(AddUserRequest request);
    void delete(Integer id);
    void update(UpdateUserRequest request);
    List<GetAllUserResponse> getAll();
    GetByIdUserResponse getById(int id);
    void add(User user);
    String findByName(String username);
}
