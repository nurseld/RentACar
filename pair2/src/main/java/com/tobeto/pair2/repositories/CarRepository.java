package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository  extends JpaRepository<Car,Integer> {
    boolean existsCarByPlate(String plate);
}
