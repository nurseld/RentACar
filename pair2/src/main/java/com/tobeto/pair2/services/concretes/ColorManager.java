package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.exceptions.BusinessException;
import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entitites.concretes.Color;
import com.tobeto.pair2.repositories.ColorRepository;
import com.tobeto.pair2.services.abstracts.ColorService;
import com.tobeto.pair2.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair2.services.dtos.color.responses.GetAllColorResponse;
import com.tobeto.pair2.services.dtos.color.responses.GetByIdColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddColorRequest request) {

        if(colorRepository.existsColorByName(request.getName().toLowerCase())){
            throw new BusinessException("This color already exists in the database.");
        }

        Color color = this.modelMapperService.forRequest().map(request, Color.class);
        this.colorRepository.save(color);


    }

    @Override
    public void update(UpdateColorRequest request) {

        Color color = this.modelMapperService.forRequest().map(request, Color.class);
        this.colorRepository.save(color);

    }

    @Override
    public void delete(Integer id) {

        Color colorToDelete = this.colorRepository.findById(id).orElseThrow();
        this.colorRepository.delete(colorToDelete);

    }



    @Override
    public List<GetAllColorResponse> getAll() {

        List<Color> colorList = colorRepository.findAll();
        List<GetAllColorResponse> colorResponse = colorList.stream()
                .map(color -> this.modelMapperService.forResponse().map(color,GetAllColorResponse.class)).toList();
        return colorResponse;
    }

    @Override
    public GetByIdColorResponse getById(int id) {

        Color color = colorRepository.findById(id).orElseThrow();
        GetByIdColorResponse response = this.modelMapperService.forResponse().map(color,GetByIdColorResponse.class);
        return response;

        }

    @Override
    public boolean existsByColorId(int colorId) {

        return colorRepository.existsById(colorId);
    }


}
