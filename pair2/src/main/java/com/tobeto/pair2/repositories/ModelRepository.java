package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {

    boolean existsModelByName(String name);

}
