package com.tobeto.pair2.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.pair2.entitites.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "models")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model extends BaseEntity {

     @Column(name = "name")
     private String name;

     @ManyToOne
     @JoinColumn(name = "brand_id")
     private Brand brand;

     @OneToMany(mappedBy = "model")
     @JsonIgnore
     private List<Car> cars;

}
