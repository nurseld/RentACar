package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.ModelRepository;
import com.tobeto.pair2.services.abstracts.BrandService;
import com.tobeto.pair2.services.constants.BusinessMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {

    private ModelRepository modelRepository;
    private BrandService brandService;

    public void checkIfModelNameExists(String name){
        if(modelRepository.existsModelByName(name)){
            throw new BusinessException(BusinessMessages.Model.SAME_MODEL_NAME_EXISTS);
        }
    }

    public void checkIfBrandIdExits(Integer id){
        if(brandService.existsByBrandId(id)){
            throw new BusinessException(BusinessMessages.Model.BRAND_ID_MUST_EXISTS);
        }
    }

}
