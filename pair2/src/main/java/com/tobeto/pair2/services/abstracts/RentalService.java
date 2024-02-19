package com.tobeto.pair2.services.abstracts;


import com.tobeto.pair2.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair2.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair2.services.dtos.rental.responses.GetAllRentalResponse;
import com.tobeto.pair2.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.pair2.services.dtos.rental.responses.OrderResponse;

import java.util.List;

public interface RentalService {

    OrderResponse add(AddRentalRequest request);
    void update(UpdateRentalRequest request);
    void delete(Integer id);
    List<GetAllRentalResponse> getAll();
    GetByIdRentalResponse getById(int id);

    List<GetAllRentalResponse> getByUserId(int id);
}
