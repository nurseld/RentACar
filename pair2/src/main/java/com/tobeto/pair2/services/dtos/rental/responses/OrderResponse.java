package com.tobeto.pair2.services.dtos.rental.responses;

import com.tobeto.pair2.entities.concretes.Invoice;
import com.tobeto.pair2.entities.concretes.Rental;
import com.tobeto.pair2.services.dtos.car.responses.GetByIdCarResponse;
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
    private GetByIdCarResponse car;
    private String invoiceNo;



    public OrderResponse(Rental rental, Invoice invoice, GetByIdCarResponse car) {
        this.totalPrice = invoice.getTotalPrice();
        this.userId = rental.getUser().getId();
        this.carId = rental.getCar().getId();
        this.car=car;
        this.invoiceNo=invoice.getInvoiceNo();

    }
}
