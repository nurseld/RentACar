package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.utilities.mapper.ModelMapperService;
import com.tobeto.pair2.entitites.User;
import com.tobeto.pair2.repositories.UserRepository;
import com.tobeto.pair2.services.abstracts.UserService;
import com.tobeto.pair2.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair2.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair2.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.pair2.services.dtos.user.responses.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddUserRequest request) {

        User user = this.modelMapperService.forRequest().map(request,User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {

        User userToDelete = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(userToDelete);
    }

    @Override
    public void update(UpdateUserRequest request) {

        User user = this.modelMapperService.forRequest().map(request,User.class);
        this.userRepository.save(user);
    }

    @Override
    public List<GetAllUserResponse> getAll() {

        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user,GetAllUserResponse.class)).toList();
        return userResponses;
    }

    @Override
    public GetByIdUserResponse getById(int id) {

        User user = userRepository.findById(id).orElseThrow();
        GetByIdUserResponse response = this.modelMapperService.forResponse().map(user,GetByIdUserResponse.class);
        return response;
    }

    @Override
    public boolean existsByUserId(int userId) {
        return userRepository.existsById(userId) ;
    }
}
