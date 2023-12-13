package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetCarByIdResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request) {
        carService.add(request);
    }
    @PutMapping
    public void update(@RequestBody UpdateCarRequest request) {
        carService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody DeleteCarRequest request) {
        carService.delete(request);
    }

    @GetMapping
    public List<GetAllCarResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetCarByIdResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }


}
