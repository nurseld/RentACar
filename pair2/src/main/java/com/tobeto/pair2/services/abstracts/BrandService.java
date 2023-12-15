package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetAllBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetDeleteBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest request);
    GetDeleteBrandResponse delete(DeleteBrandRequest request);
    List<GetAllBrandResponse> getAll();
    GetByIdBrandResponse getById(int id);


}
