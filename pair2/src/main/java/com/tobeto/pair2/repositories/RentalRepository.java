package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entitites.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository  extends JpaRepository<Rental,Integer> {
    List<Rental> findByUserId(int id);
}
