package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.dtos.brand.responses.GetBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.pair2.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair2.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair2.services.dtos.color.responses.GetColorResponse;
import com.tobeto.pair2.services.dtos.color.responses.GetListColorResponse;

import java.util.List;

public interface ColorService {

    void add(AddColorRequest request);
    void update(UpdateColorRequest request);
    void delete(DeleteColorRequest request);
    List<GetListColorResponse> getAll();
    GetColorResponse getById(int id);


}
