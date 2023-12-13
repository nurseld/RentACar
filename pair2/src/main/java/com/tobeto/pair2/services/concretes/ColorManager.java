package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.entitites.Brand;
import com.tobeto.pair2.entitites.Color;
import com.tobeto.pair2.repositories.ColorRepository;
import com.tobeto.pair2.services.abstracts.ColorService;
import com.tobeto.pair2.services.dtos.brand.responses.GetBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.pair2.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair2.services.dtos.color.responses.GetColorResponse;
import com.tobeto.pair2.services.dtos.color.responses.GetListColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;

    @Override
    public void add(AddColorRequest request) {
        Color color = new Color();
        color.setName(request.getName());
        colorRepository.save(color);


    }

    @Override
    public void update(UpdateColorRequest request) {
        Color colorToUpdate = colorRepository.findById(request.getId()).orElseThrow();
        colorToUpdate.setName(request.getName());
        colorRepository.save(colorToUpdate);

    }

    @Override
    public void delete(DeleteColorRequest request) {
        Color colorToDelete = colorRepository.findById(request.getId()).orElseThrow();
        colorRepository.delete(colorToDelete);

    }

    @Override
    public List<GetListColorResponse> getAll() {

        List<Color> colorList = colorRepository.findAll();
        List<GetListColorResponse> getAllColorResponseList = new ArrayList<>();
       /* for (Color color : colorList) {
            GetListColorResponse getListColorResponse = new GetListColorResponse();
            getListColorResponse.setId(color.getId());
            getListColorResponse.setName(color.getName());

        }*/
        return null; //getAllColorResponseList
    }

    @Override
    public Color getById(int id) {


        return colorRepository.findById(id).orElseThrow();

        }


}
