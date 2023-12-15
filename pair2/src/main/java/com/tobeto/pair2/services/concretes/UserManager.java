package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.repositories.UserRepository;
import com.tobeto.pair2.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    @Override
    public boolean existsByUserId(int userId) {
        return userRepository.existsById(userId) ;
    }
}
