package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.entitites.Brand;
import com.tobeto.pair2.repositories.BrandRepository;
import com.tobeto.pair2.services.abstracts.BrandService;
import com.tobeto.pair2.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair2.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair2.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair2.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void add(AddBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest request) {
        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow();
        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);

    }

    @Override
    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);

    }

    @Override
    public List<GetListBrandResponse> getAll() {

        List<Brand> brandList = brandRepository.findAll();
        List<GetListBrandResponse> getAllBrandResponseList = new ArrayList<>();
        for (Brand brand : brandList) {
            GetListBrandResponse getAllBrandResponse = new GetListBrandResponse();
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
