package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair2.services.dtos.color.responses.GetAllColorResponse;
import com.tobeto.pair2.services.dtos.color.responses.GetByIdColorResponse;

import java.util.List;

public interface ColorService {

    void add(AddColorRequest request);
    void update(UpdateColorRequest request);
    void delete(DeleteColorRequest request);
    List<GetAllColorResponse> getAll();
    GetByIdColorResponse getById(int id);

}
