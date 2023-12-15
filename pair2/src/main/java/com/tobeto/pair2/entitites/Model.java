package com.tobeto.pair2.entitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Model {

     @Id
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @Column(name = "name")
     private String name;

     @ManyToOne
     @JoinColumn(name = "brand_id")
     private Brand brand;

     @OneToMany(mappedBy = "model")
     @JsonIgnore
     private List<Car> cars;

}
