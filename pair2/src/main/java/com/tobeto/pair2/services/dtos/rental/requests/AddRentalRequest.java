package com.tobeto.pair2.services.dtos.rental.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {

    private LocalDate startDate;
    private LocalDate endDate;
    private int carId;
    private int userId;



}
