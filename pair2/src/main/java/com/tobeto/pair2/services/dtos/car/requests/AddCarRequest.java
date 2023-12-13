package com.tobeto.pair2.services.dtos.car.requests;

import com.tobeto.pair2.services.dtos.color.responses.GetColorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private int kilometer;
    private String plate;
    private int year;
    private double dailyPrice;
    private int modelId;
    private GetColorResponse color;
}
