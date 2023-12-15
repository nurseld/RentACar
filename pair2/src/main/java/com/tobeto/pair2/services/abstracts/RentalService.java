package com.tobeto.pair2.services.abstracts;


import com.tobeto.pair2.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair2.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair2.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair2.services.dtos.rental.responses.GetAllRentalResponse;
import com.tobeto.pair2.services.dtos.rental.responses.GetByIdRentalResponse;

import java.util.List;

public interface RentalService {

    void add(AddRentalRequest request);
    void update(UpdateRentalRequest request);
    void delete(DeleteRentalRequest request);
    List<GetAllRentalResponse> getAll();
    GetByIdRentalResponse getById(int id);
}
