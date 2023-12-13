package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.entitites.Model;
import com.tobeto.pair2.repositories.ModelRepository;
import com.tobeto.pair2.services.abstracts.ModelService;
import com.tobeto.pair2.services.dtos.model.responses.GetModelByIdResponse;
import io.swagger.v3.core.jackson.ModelResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    @Override
    public Model getById(int id) {
        return modelRepository.findById(id).orElseThrow();
    }

    //@Override
   /* public GetModelByIdResponse getById(int modelId) {
        return null;
    }*/


}
