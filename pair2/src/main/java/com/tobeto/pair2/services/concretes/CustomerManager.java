package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entitites.concretes.Customer;
import com.tobeto.pair2.repositories.CustomerRepository;
import com.tobeto.pair2.services.abstracts.CustomerService;
import com.tobeto.pair2.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair2.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.pair2.services.dtos.customer.responses.GetAllCustomerResponse;
import com.tobeto.pair2.services.dtos.customer.responses.GetByIdCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddCustomerRequest request) {

        Customer customer = this.modelMapperService.forRequest().map(request,Customer.class);
        this.customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest request) {

        Customer customer = this.modelMapperService.forRequest().map(request,Customer.class);
        this.customerRepository.save(customer);

    }

    @Override
    public void delete(Integer id) {

       Customer customerToDelete = this.customerRepository.findById(id).orElseThrow();
       this.customerRepository.delete(customerToDelete);
    }

    @Override
    public List<GetAllCustomerResponse> getAll() {

        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponse> customerResponses = customers.stream()
                .map(customer -> this.modelMapperService.forResponse().map(customer,GetAllCustomerResponse.class)).toList();
        return customerResponses;
    }

    @Override
    public GetByIdCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return response;
    }
}
