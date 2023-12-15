package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair2.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.pair2.services.dtos.car.responses.GetDeleteCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    GetDeleteCarResponse delete(DeleteCarRequest request);
    List<GetAllCarResponse> getAll();
    GetByIdCarResponse getById(int id);
    boolean existsByCarId(int carId);
}
