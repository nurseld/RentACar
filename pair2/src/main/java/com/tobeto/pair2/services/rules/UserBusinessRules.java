package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.UserRepository;
import com.tobeto.pair2.services.constants.BusinessMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {

    private UserRepository userRepository;

    public void checkIfEmailExists(String email){
        if(userRepository.existsUserByEmail(email)){
            throw new BusinessException(BusinessMessages.User.SAME_EMAIL_EXISTS);
        }
    }
}
