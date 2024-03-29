package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsBrandByName(String name);
}
