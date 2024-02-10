package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.corporatecustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair2.services.dtos.corporatecustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair2.services.dtos.corporatecustomer.responses.GetAllCorporateCustomerResponse;
import com.tobeto.pair2.services.dtos.corporatecustomer.responses.GetByIdCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {

    void add(AddCorporateCustomerRequest request);

    void update(UpdateCorporateCustomerRequest request);

    void delete(Integer id);

    List<GetAllCorporateCustomerResponse> getAll();

    GetByIdCorporateCustomerResponse getById(int id);
}
