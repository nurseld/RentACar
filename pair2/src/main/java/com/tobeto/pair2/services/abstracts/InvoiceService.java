package com.tobeto.pair2.services.abstracts;

import com.tobeto.pair2.entitites.concretes.Invoice;
import com.tobeto.pair2.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair2.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair2.services.dtos.invoice.responses.GetAllInvoiceResponse;
import com.tobeto.pair2.services.dtos.invoice.responses.GetByIdInvoiceResponse;

import java.util.List;

public interface InvoiceService {

    Invoice add(AddInvoiceRequest request);
    void update(UpdateInvoiceRequest request);
    void delete(Integer id);
    List<GetAllInvoiceResponse> getAll();
    GetByIdInvoiceResponse getById(int id);


}
