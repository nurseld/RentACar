package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.dtos.rental.requests.AvailableCarRentalRequest;
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        carService.delete(id);
    }

    @GetMapping("/getAll")
    public List<GetAllCarResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @PostMapping("/getAvailableCars")
    public List<GetAllCarResponse> getAvailableCarsForRent(@RequestBody AvailableCarRentalRequest request) {
        return carService.listAvailableCarsForRent(request);
    }

}
