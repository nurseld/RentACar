package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.BrandService;
import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @PostMapping("/add")
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteBrandRequest request){
        brandService.delete(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateBrandRequest request) {
        brandService.update(request);
    }

    @GetMapping("/getall")
    public List<GetListBrandResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }



}
