package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.ColorRepository;
import com.tobeto.pair2.services.constants.BusinessMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ColorBusinessRules {

    private ColorRepository colorRepository;

    public void checkIfColorNameExists(String name){
        if(colorRepository.existsColorByName(name)){
            throw new BusinessException(BusinessMessages.Color.SAME_COLOR_EXISTS);
        }
    }
}
