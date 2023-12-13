package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.entitites.Model;
import com.tobeto.pair2.services.dtos.model.responses.GetModelByIdResponse;

public interface ModelService {

    //GetModelByIdResponse getById(int modelId);

    Model getById(int id);
}
