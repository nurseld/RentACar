package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entitites.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByUserId(int userId);

}
