package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entitites.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository  extends JpaRepository<Rental,Integer> {
}
