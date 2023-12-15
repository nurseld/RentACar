package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.ModelService;
import com.tobeto.pair2.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair2.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.pair2.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair2.services.dtos.model.responses.GetAllModelResponse;
import com.tobeto.pair2.services.dtos.model.responses.GetByIdModelResponse;
import com.tobeto.pair2.services.dtos.model.responses.GetDeleteModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/models")
public class ModelsContoller {
    private final ModelService modelService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddModelRequest request) {
        modelService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateModelRequest request) {
        modelService.update(request);
    }

    @DeleteMapping("/delete")
    public GetDeleteModelResponse delete(@RequestBody DeleteModelRequest request) {
        return modelService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetAllModelResponse> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdModelResponse getById(@PathVariable int id) {
        return modelService.getById(id);
    }


}
