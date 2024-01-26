package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){

        if(brandRepository.existsBrandByName(name)){
            throw new BusinessException("This brand already exists in the database.");
        }

    }
}
