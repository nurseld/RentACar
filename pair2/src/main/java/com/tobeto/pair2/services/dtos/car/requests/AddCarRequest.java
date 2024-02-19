package com.tobeto.pair2.services.dtos.car.requests;

import com.tobeto.pair2.entitites.concretes.BodyType;
import com.tobeto.pair2.entitites.concretes.FuelType;
import com.tobeto.pair2.entitites.concretes.GearType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @Positive(message = "Kilometer should be a greater than 0.")
    private int kilometer;

    @NotBlank(message = "Plate number !")
    @Pattern(regexp = "^(0[1-9]|[1-7][0-9]|8[01])(([A-Z])(\\d{4,5})|([A-Z]{2})(\\d{3,4})|([A-Z]{3})(\\d{2,3}))$", message = " Plate should be a valid Turkish plate format.")
    private String plate;

    public void setPlate(String plate) {
        this.plate = plate != null ? plate.replaceAll("\s", "") : null;
    }

    @Min(value = 2005, message = "Year should be 2005 or greater.")
    @Max(value = 2024, message = "Year should be 2024 or less.")
    private int year;

    private GearType gearType;

    private FuelType fuelType;

    private BodyType bodyType;

    @Positive(message = "Daily price should be a greater than 0.")
    private double dailyPrice;

    @Positive(message = "ModelId should be a greater than 0.")
    private int modelId;

    @Positive(message = "ColorId should be a greater than 0.")
    private int colorId;

}
