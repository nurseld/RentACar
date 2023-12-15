package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.RentalService;
import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetDeleteCarResponse;
import com.tobeto.pair2.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair2.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair2.services.dtos.rental.responses.GetAllRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalService rentalService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddRentalRequest request) {
        rentalService.add(request);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateRentalRequest request) {
        rentalService.update(request);
    }

    @GetMapping("/getAll")
    public List<GetAllRentalResponse> getAll() {
        return rentalService.getAll();
    }

}
