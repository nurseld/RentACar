package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.CorporateCustomerService;
import com.tobeto.pair2.services.dtos.corporatecustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair2.services.dtos.corporatecustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair2.services.dtos.corporatecustomer.responses.GetAllCorporateCustomerResponse;
import com.tobeto.pair2.services.dtos.corporatecustomer.responses.GetByIdCorporateCustomerResponse;
import com.tobeto.pair2.services.dtos.corporatecustomer.responses.GetByUserIdCorporateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corporate")
@AllArgsConstructor
public class CorporateCustomersController {
    private final CorporateCustomerService corporateCustomerService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCorporateCustomerRequest request){
        corporateCustomerService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCorporateCustomerRequest request){
        corporateCustomerService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        corporateCustomerService.delete(id);
    }

    @GetMapping("/getAll")
    public List<GetAllCorporateCustomerResponse> getAll(){
        return corporateCustomerService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdCorporateCustomerResponse getById(@PathVariable int id){
        return corporateCustomerService.getById(id);
    }

    @GetMapping("/getByUserId/{userId}")
    public GetByUserIdCorporateCustomerResponse getByUserId(@PathVariable int userId){
        return corporateCustomerService.getByUserId(userId);
    }
}
