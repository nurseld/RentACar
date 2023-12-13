package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.BrandService;
import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.dtos.brand.responses.GetBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody DeleteBrandRequest request){
        brandService.delete(request);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody UpdateBrandRequest request) {
        brandService.update(request);
    }

    @GetMapping("getall")
    public List<GetListBrandResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }



}
