package com.tobeto.pair2.services.dtos.car.responses;

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

    private String modelName;

    private String colorName;

    private String brandName;

}
