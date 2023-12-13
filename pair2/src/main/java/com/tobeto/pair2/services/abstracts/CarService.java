package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.entitites.Car;
import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetCarByIdResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(DeleteCarRequest request);
    List<GetAllCarResponse> getAll();
    GetCarByIdResponse getById(int id);

}
