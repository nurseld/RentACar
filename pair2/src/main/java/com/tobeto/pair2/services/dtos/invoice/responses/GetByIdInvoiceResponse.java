package com.tobeto.pair2.services.dtos.invoice.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdInvoiceResponse {

    private LocalDate createDate;

    private int rentalId;
}
