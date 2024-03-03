package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color,Integer> {
    boolean existsColorByName(String name);

}
