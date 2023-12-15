package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.BrandService;
import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetAllBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetDeleteBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddBrandRequest request) {
        brandService.add(request);
    }

    @DeleteMapping("/delete")
    public GetDeleteBrandResponse delete(@RequestBody DeleteBrandRequest request) {
       return brandService.delete(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateBrandRequest request) {
        brandService.update(request);
    }

    @GetMapping("/getall")
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

}
