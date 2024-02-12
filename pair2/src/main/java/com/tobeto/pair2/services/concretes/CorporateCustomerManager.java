package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entitites.concretes.CorporateCustomer;
import com.tobeto.pair2.entitites.concretes.User;
import com.tobeto.pair2.repositories.CorporateCustomerRepository;
import com.tobeto.pair2.services.abstracts.CorporateCustomerService;
import com.tobeto.pair2.services.dtos.corporatecustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair2.services.dtos.corporatecustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair2.services.dtos.corporatecustomer.responses.GetAllCorporateCustomerResponse;
import com.tobeto.pair2.services.dtos.corporatecustomer.responses.GetByIdCorporateCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CorporateCustomerManager implements CorporateCustomerService {

    private final CorporateCustomerRepository corporateCustomerRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddCorporateCustomerRequest request) {
        CorporateCustomer corporateCustomer = CorporateCustomer.builder()
                .companyName(request.getCompanyName())
                .taxNo(request.getTaxNo())
                .contactName(request.getContactName())
                .phoneNumber(request.getPhoneNumber())
                .user(new User(request.getUserId()))
                .build();
        this.corporateCustomerRepository.save(corporateCustomer);

    }

    @Override
    public void update(UpdateCorporateCustomerRequest request) {

        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest().map(request,CorporateCustomer.class);
        this.corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public void delete(Integer id) {
        CorporateCustomer corporateCustomerToDelete = this.corporateCustomerRepository.findById(id).orElseThrow();
        this.corporateCustomerRepository.delete(corporateCustomerToDelete);

    }

    @Override
    public List<GetAllCorporateCustomerResponse> getAll() {
        List<CorporateCustomer> corporateCustomers = corporateCustomerRepository.findAll();
        List<GetAllCorporateCustomerResponse> corporateCustomerResponses = corporateCustomers.stream()
                .map(corporateCustomer -> this.modelMapperService.forResponse().map(corporateCustomer, GetAllCorporateCustomerResponse.class)).toList();

        return corporateCustomerResponses;
    }

    @Override
    public GetByIdCorporateCustomerResponse getById(int id) {
        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(id).orElseThrow();
        GetByIdCorporateCustomerResponse response = this.modelMapperService.forResponse().map(corporateCustomer,GetByIdCorporateCustomerResponse.class);
        return response;
    }

    @Override
    public GetByIdCorporateCustomerResponse getByUserId(int userId) {
        GetByIdCorporateCustomerResponse response = this.modelMapperService.forResponse().map(corporateCustomerRepository.findByUserId(userId),GetByIdCorporateCustomerResponse.class);
        return response;
    }
}
