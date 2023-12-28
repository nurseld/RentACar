package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entitites.concretes.Model;
import com.tobeto.pair2.repositories.ModelRepository;
import com.tobeto.pair2.services.abstracts.BrandService;
import com.tobeto.pair2.services.abstracts.ModelService;
import com.tobeto.pair2.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair2.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair2.services.dtos.model.responses.GetAllModelResponse;
import com.tobeto.pair2.services.dtos.model.responses.GetByIdModelResponse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    private final BrandService brandService;

    public void add(AddModelRequest request) {

        if (modelRepository.existsModelByName(request.getName())) {
            throw new BusinessException("This model already exists in the database.");
        }

        if(!brandService.existsByBrandId(request.getBrandId())) {
            throw new BusinessException("The ModelId must exist in the database.");
        }

        Model model = this.modelMapperService.forRequest().map(request, Model.class);
        this.modelRepository.save(model);


    }

    @Override
    public void update(UpdateModelRequest request) {

        Model model = this.modelMapperService.forRequest().map(request, Model.class);
        this.modelRepository.save(model);

    }

    @Override
    public void delete(Integer id) {

        Model modelToDelete = this.modelRepository.findById(id).orElseThrow();
        this.modelRepository.deleteById(id);
    }


    @Override
    public List<GetAllModelResponse> getAll() {

        List<Model> modelList = modelRepository.findAll();
        List<GetAllModelResponse> modelResponses = modelList.stream()
                .map(model -> this.modelMapperService.forResponse().map(model,GetAllModelResponse.class)).toList();
        return modelResponses;
    }

    @Override
    public GetByIdModelResponse getById(int id) {

        Model model = modelRepository.findById(id).orElseThrow();
        GetByIdModelResponse response = this.modelMapperService.forResponse().map(model,GetByIdModelResponse.class);
        return response;

    }

    @Override
    public boolean existsByModelId(int modelId) {

        return modelRepository.existsById(modelId);
    }


}



