package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entitites.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color,Integer> {
    boolean existsColorByName(String name);

}
