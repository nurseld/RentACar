package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.utilities.mapper.ModelMapperService;
import com.tobeto.pair2.entitites.Brand;
import com.tobeto.pair2.repositories.BrandRepository;
import com.tobeto.pair2.services.abstracts.BrandService;
import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetAllBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetDeleteBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;


    @Override
    public void add(AddBrandRequest request) {
        if (brandRepository.existsBrand(request.getName())) {
            throw new RuntimeException("This brand already exists in the database.");
        }
            Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
            this.brandRepository.save(brand);

        }

    @Override
    public void update(UpdateBrandRequest request) {
        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public GetDeleteBrandResponse delete(DeleteBrandRequest request) {
        Brand brand = brandRepository.findById(request.getId()).orElseThrow();

        GetDeleteBrandResponse response = this.modelMapperService.forResponse().map(brand, GetDeleteBrandResponse.class);

        this.brandRepository.delete(brand);

        return response;

    }

    @Override
    public List<GetAllBrandResponse> getAll() {

        List<Brand> brandList = brandRepository.findAll();
        List<GetAllBrandResponse> getAllBrandResponseList = new ArrayList<>();
        for (Brand brand : brandList) {
            GetAllBrandResponse getAllBrandResponse = new GetAllBrandResponse();
            getAllBrandResponse.setId(brand.getId());
            getAllBrandResponse.setName(brand.getName());

        }
        return getAllBrandResponseList;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brandToId = brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse getByIdBrandResponse = new GetByIdBrandResponse();
        getByIdBrandResponse.setName(brandToId.getName());
        return getByIdBrandResponse;
    }
}
