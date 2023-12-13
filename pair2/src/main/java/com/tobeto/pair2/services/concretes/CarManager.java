package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.utilities.mapper.ModelMapperService;
import com.tobeto.pair2.entitites.Brand;
import com.tobeto.pair2.entitites.Car;
import com.tobeto.pair2.entitites.Color;
import com.tobeto.pair2.entitites.Model;
import com.tobeto.pair2.repositories.CarRepository;
import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.abstracts.ColorService;
import com.tobeto.pair2.services.abstracts.ModelService;
import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetCarByIdResponse;
import com.tobeto.pair2.services.dtos.model.responses.GetModelByIdResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelService modelService;
    private final ColorService colorService;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddCarRequest request) {

        Car car = modelMapperService.forRequest().map(request, Car.class);
        carRepository.save(car);

        /*Car car = new Car();
        car.setKilometer(request.getKilometer());
        car.setPlate(request.getPlate());
        car.setYear(request.getYear());
        car.setDailyPrice(request.getDailyPrice());


        Model model = modelService.getById(request.getModelId());
        //GetModelByIdResponse getModelByIdResponse = modelService.getById(request.getModelId());
        car.setModel(model);

        Color color = colorService.getById(request.getColorId());
        car.setColor(color);

        carRepository.save(car);*/


    }

    @Override
    public void update(UpdateCarRequest request) {
        Car car = modelMapperService.forRequest().map(request, Car.class);
        carRepository.save(car);


    }

    @Override
    public void delete(DeleteCarRequest request) {
        Car car = modelMapperService.forRequest().map(request, Car.class);
        carRepository.delete(car);


    }

    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> cars = carRepository.findAll();

        return cars.stream().map(car -> modelMapperService.forResponse().map(car,GetAllCarResponse.class)).toList();
    }

    @Override
    public GetCarByIdResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(car, GetCarByIdResponse.class);
    }



}
