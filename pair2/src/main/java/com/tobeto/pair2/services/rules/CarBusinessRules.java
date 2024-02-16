package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.CarRepository;
import com.tobeto.pair2.services.abstracts.ColorService;
import com.tobeto.pair2.services.abstracts.ModelService;
import com.tobeto.pair2.services.constants.BusinessMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {

    private CarRepository carRepository;
    private ModelService modelService;
    private ColorService colorService;


    public void checkIfCarPlateExists(String plate){
        if(carRepository.existsCarByPlate(plate)){
            throw new BusinessException(BusinessMessages.Car.SAME_PLATE_EXISTS);
        }
    }

    public void checkIfModelIdExists(Integer id){
        if(!modelService.existsByModelId(id)){
            throw new BusinessException(BusinessMessages.Car.MODEL_ID_MUST_EXISTS);
        }
    }

    public void checkIfColorIdExists(Integer id){
        if(!colorService.existsByColorId(id)){
            throw new BusinessException(BusinessMessages.Car.COLOR_ID_MUST_EXISTS);
        }
    }

}
