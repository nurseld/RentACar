package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.RentalService;
import com.tobeto.pair2.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair2.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair2.services.dtos.rental.responses.GetAllRentalResponse;
import com.tobeto.pair2.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.pair2.services.dtos.rental.responses.OrderResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rentals")
public class RentalsController {

    private final RentalService rentalService;

    @PostMapping("/add")
    public OrderResponse add(@RequestBody @Valid AddRentalRequest request) {
        return rentalService.add(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        rentalService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateRentalRequest request) {
        rentalService.update(request);
    }

    @GetMapping("/getAll")
    public List<GetAllRentalResponse> getAll() {
        return rentalService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdRentalResponse getById(@PathVariable int id) {
        return rentalService.getById(id);
    }

    @GetMapping("/getByUserId/{id}")
    public List<GetAllRentalResponse> getByUserId(@PathVariable int id) {
        return rentalService.getByUserId(id);
    }
}
