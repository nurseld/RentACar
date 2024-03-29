package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer,Integer> {
    CorporateCustomer findByUserId(int userId);
}
