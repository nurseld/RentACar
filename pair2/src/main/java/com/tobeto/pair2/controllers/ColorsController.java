package com.tobeto.pair2.controllers;

import com.tobeto.pair2.services.abstracts.ColorService;
import com.tobeto.pair2.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair2.services.dtos.color.responses.GetByIdColorResponse;
import com.tobeto.pair2.services.dtos.color.responses.GetAllColorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
@AllArgsConstructor
public class ColorsController {

    private ColorService colorService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddColorRequest request){
        colorService.add(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteColorRequest request){
        colorService.delete(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateColorRequest request) {
        colorService.update(request);
    }

    @GetMapping("/getAll")
    public List<GetAllColorResponse> getAll() {
        return colorService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdColorResponse getById(@PathVariable int id) {
        return colorService.getById(id);
    }

}
