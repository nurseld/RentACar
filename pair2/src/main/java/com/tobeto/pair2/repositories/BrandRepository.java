package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entitites.Brand;
import com.tobeto.pair2.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {


}
