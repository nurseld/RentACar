package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ColorBusinessRules {

    private ColorRepository colorRepository;

    public void checkIfColorNameExists(String name){
        if(colorRepository.existsColorByName(name)){
            throw new BusinessException("This color already exists in the database.");
        }
    }
}
