package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair2.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair2.services.dtos.model.responses.GetAllModelResponse;
import com.tobeto.pair2.services.dtos.model.responses.GetByIdModelResponse;

import java.util.List;

public interface ModelService {
    void add(AddModelRequest request);
    void update(UpdateModelRequest request);
    void delete(Integer id);
    List<GetAllModelResponse> getAll();
    GetByIdModelResponse getById(int id);
    boolean existsByModelId(int modelId);
}
