package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entitites.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
