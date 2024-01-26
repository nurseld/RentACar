package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entitites.concretes.Car;
import com.tobeto.pair2.repositories.CarRepository;
import com.tobeto.pair2.services.abstracts.CarService;
import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.rules.CarBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final CarBusinessRules carBusinessRules;

    @Override
    public void add(AddCarRequest request) {

       this.carBusinessRules.checkIfCarPlateExists(request.getPlate());
       this.carBusinessRules.checkIfModelIdExists(request.getModelId());
       this.carBusinessRules.checkIfColorIdExists(request.getColorId());

        Car car = this.modelMapperService.forRequest().map(request, Car.class);
        this.carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest request) {

        Car car = this.modelMapperService.forRequest().map(request, Car.class);
        this.carRepository.save(car);

    }

    @Override
    public void delete(Integer id) {

        Car car = this.carRepository.findById(id).orElseThrow();
        this.carRepository.delete(car);
    }


    @Override
    public List<GetAllCarResponse> getAll() {

        List<Car> cars = carRepository.findAll();
        List<GetAllCarResponse> carResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car,GetAllCarResponse.class)).toList();
        return carResponses;
    }

    @Override
    public GetByIdCarResponse getById(int id) {

        Car car = carRepository.findById(id).orElseThrow();
        GetByIdCarResponse response = this.modelMapperService.forResponse().map(car,GetByIdCarResponse.class);
        return response;

    }

    @Override
    public boolean existsByCarId(int carId) {

        return carRepository.existsById(carId);
    }


}
