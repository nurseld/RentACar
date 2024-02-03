package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.BrandRepository;
import com.tobeto.pair2.services.constants.BusinessMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){

        if(brandRepository.existsBrandByName(name)){
            throw new BusinessException(BusinessMessages.Brand.SAME_BRAND_EXISTS);
        }

    }
}
