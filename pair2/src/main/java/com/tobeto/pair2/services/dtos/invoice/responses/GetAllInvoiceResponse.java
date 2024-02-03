package com.tobeto.pair2.services.dtos.invoice.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoiceResponse {

//    private LocalDate createDate;

    private String  invoiceNo;

    private Float totalPrice;

    private int rentalId;
}
