package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.CustomerService;
import com.tobeto.pair2.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair2.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.pair2.services.dtos.customer.responses.GetAllCustomerResponse;
import com.tobeto.pair2.services.dtos.customer.responses.GetByIdCustomerResponse;
import com.tobeto.pair2.services.dtos.customer.responses.GetByUserIdCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCustomerRequest request){
        customerService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCustomerRequest request){
        customerService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        customerService.delete(id);
    }

    @GetMapping("/getAll")
    public List<GetAllCustomerResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdCustomerResponse getById(@PathVariable int id){
        return customerService.getById(id);
    }

    @GetMapping("/getByUserId/{userId}")
    public GetByUserIdCustomerResponse getByUserId(@PathVariable int userId){
        return customerService.getByUserId(userId);
    }


}
