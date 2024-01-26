package com.tobeto.pair2.services.rules;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.repositories.CarRepository;
import com.tobeto.pair2.services.abstracts.ColorService;
import com.tobeto.pair2.services.abstracts.ModelService;
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
            throw new BusinessException("Another car cannot be added with the same license plate.");
        }
    }

    public void checkIfModelIdExists(Integer id){
        if(modelService.existsByModelId(id)){
            throw new BusinessException("The ModelId must exist in the database.");
        }
    }

    public void checkIfColorIdExists(Integer id){
        if(colorService.existsByColorId(id)){
            throw new BusinessException("The ColorId must exist in the database.");
        }
    }

}
