package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(Integer id);
    List<GetAllCarResponse> getAll();
    GetByIdCarResponse getById(int id);
    boolean existsByCarId(int carId);
}
