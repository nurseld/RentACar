package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetDeleteCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarService carService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCarRequest request) {
        carService.add(request);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCarRequest request) {
        carService.update(request);
    }

    @DeleteMapping("/delete")
    public GetDeleteCarResponse delete(@RequestBody DeleteCarRequest request) {
        return carService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetAllCarResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }


}
