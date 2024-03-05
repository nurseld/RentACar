package com.tobeto.pair2.services.dtos.car.responses;

import com.tobeto.pair2.entities.concretes.BodyType;
import com.tobeto.pair2.entities.concretes.FuelType;
import com.tobeto.pair2.entities.concretes.GearType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {

    private  int id;

    private int kilometer;

    private String plate;

    private int year;

    private double dailyPrice;

    private String imagePath;

    private GearType gearType;

    private FuelType fuelType;

    private BodyType bodyType;

    private String modelName;

    private String colorName;

    private String brandName;



}
