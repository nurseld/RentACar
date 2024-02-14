package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair2.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.pair2.services.dtos.customer.responses.GetAllCustomerResponse;
import com.tobeto.pair2.services.dtos.customer.responses.GetByIdCustomerResponse;
import com.tobeto.pair2.services.dtos.customer.responses.GetByUserIdCustomerResponse;

import java.util.List;

public interface CustomerService {

    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(Integer id);
    List<GetAllCustomerResponse> getAll();
    GetByIdCustomerResponse getById(int id);
    GetByUserIdCustomerResponse getByUserId(int userId);

}
