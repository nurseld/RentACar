package com.tobeto.pair2.services.dtos.rental.responses;

import com.tobeto.pair2.entitites.concretes.Invoice;
import com.tobeto.pair2.entitites.concretes.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Double totalPrice;
    private int userId;
    private int carId;

    public OrderResponse(Rental rental, Invoice invoice) {
        this.totalPrice = invoice.getTotalPrice();
        this.userId = rental.getUser().getId();
        this.carId = rental.getCar().getId();
    }
}
