package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.BrandService;
import com.tobeto.pair2.services.abstracts.ColorService;
import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.dtos.brand.responses.GetBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.pair2.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair2.services.dtos.color.responses.GetColorResponse;
import com.tobeto.pair2.services.dtos.color.responses.GetListColorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
public class ColorsController {

    private ColorService colorService;

    @PostMapping
    public void add(@RequestBody AddColorRequest request){
        colorService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody DeleteColorRequest request){
        colorService.delete(request);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody UpdateColorRequest request) {
        colorService.update(request);
    }

    @GetMapping("getall")
    public List<GetListColorResponse> getAll() {
        return colorService.getAll();
    }

    @GetMapping("{id}")
    public GetColorResponse getById(@PathVariable int id){
        return colorService.getById(id);
    }

}
