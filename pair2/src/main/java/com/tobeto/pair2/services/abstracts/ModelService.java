package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.pair2.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair2.services.dtos.model.responses.GetAllModelResponse;
import com.tobeto.pair2.services.dtos.model.responses.GetByIdModelResponse;

import java.util.List;

public interface ModelService {

    void update(UpdateModelRequest request);

    void delete(DeleteModelRequest request);

    List<GetAllModelResponse> getAll();

    GetByIdModelResponse getById(int id);


}
