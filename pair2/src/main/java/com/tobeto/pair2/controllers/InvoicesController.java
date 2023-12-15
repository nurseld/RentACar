package com.tobeto.pair2.controllers;


import com.tobeto.pair2.services.abstracts.InvoiceService;
import com.tobeto.pair2.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair2.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair2.services.dtos.invoice.responses.GetAllInvoiceResponse;
import com.tobeto.pair2.services.dtos.invoice.responses.GetByIdInvoiceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

    private final InvoiceService invoiceService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddInvoiceRequest request) {
        invoiceService.add(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        invoiceService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateInvoiceRequest request) {
        invoiceService.update(request);
    }

    @GetMapping("/getall")
    public List<GetAllInvoiceResponse> getAll() {
        return invoiceService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdInvoiceResponse getById(@PathVariable int id) {
        return invoiceService.getById(id);
    }
}
