package com.tobeto.pair2.services.concretes;

import com.tobeto.pair2.core.mapper.services.ModelMapperService;
import com.tobeto.pair2.entitites.concretes.Invoice;
import com.tobeto.pair2.repositories.InvoiceRepository;
import com.tobeto.pair2.services.abstracts.InvoiceService;
import com.tobeto.pair2.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair2.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair2.services.dtos.invoice.responses.GetAllInvoiceResponse;
import com.tobeto.pair2.services.dtos.invoice.responses.GetByIdInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public Invoice add(AddInvoiceRequest request) {

        Invoice invoice = this.modelMapperService.forRequest().map(request,Invoice.class);
        return this.invoiceRepository.save(invoice);
    }

    @Override
    public void update(UpdateInvoiceRequest request) {

        Invoice invoice = this.modelMapperService.forRequest().map(request,Invoice.class);
        this.invoiceRepository.save(invoice);
    }

    @Override
    public void delete(Integer id) {

        Invoice invoiceToDelete = this.invoiceRepository.findById(id).orElseThrow();
        this.invoiceRepository.delete(invoiceToDelete);
    }

    @Override
    public List<GetAllInvoiceResponse> getAll() {

        List<Invoice> invoices = invoiceRepository.findAll();
        List<GetAllInvoiceResponse> invoiceResponses = invoices.stream()
                .map(invoice -> this.modelMapperService.forResponse().map(invoice,GetAllInvoiceResponse.class)).toList();
        return invoiceResponses;
    }

    @Override
    public GetByIdInvoiceResponse getById(int id) {

        Invoice invoice = invoiceRepository.findById(id).orElseThrow();
        GetByIdInvoiceResponse response = this.modelMapperService.forResponse().map(invoice,GetByIdInvoiceResponse.class);
        return response;
    }

}

