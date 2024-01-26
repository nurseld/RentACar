package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.ModelRepository;
import com.tobeto.pair2.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {

    private ModelRepository modelRepository;
    private BrandService brandService;

    public void checkIfModelNameExists(String name){
        if(modelRepository.existsModelByName(name)){
            throw new BusinessException("This model already exists in the database.");
        }
    }

    public void checkIfBrandIdExits(Integer id){
        if(brandService.existsByBrandId(id)){
            throw new BusinessException("The ModelId must exist in the database.");
        }
    }

}
