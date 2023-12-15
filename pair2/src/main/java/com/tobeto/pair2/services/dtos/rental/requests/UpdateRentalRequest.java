package com.tobeto.pair2.services.dtos.rental.requests;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    @Positive
    private int id;

    @Nullable
    private LocalDate startDate;

    @Nullable
    private LocalDate endDate;

    @Nullable
    private LocalDate returnDate;

    @Nullable
    private Integer endKilometer;

//    @Positive
//    private double totalPrice;

    private int carId;
    private int userId;
}

