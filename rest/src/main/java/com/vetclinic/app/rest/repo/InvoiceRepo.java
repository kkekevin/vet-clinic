package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Integer>{
    
}
