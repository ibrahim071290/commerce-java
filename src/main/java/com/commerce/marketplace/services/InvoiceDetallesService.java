package com.commerce.marketplace.services;

import com.commerce.marketplace.entities.InvoiceDetalle;
import com.commerce.marketplace.repositories.InvoiceDetallesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetallesService {

    @Autowired
    private InvoiceDetallesRepository repository;

    public InvoiceDetalle save(InvoiceDetalle invoiceDetalle){
        return repository.save(invoiceDetalle);
    }

    public List<InvoiceDetalle> read(){
        return  repository.findAll();
    }

    public Optional<InvoiceDetalle> readOne(Long id){
        return  repository.findById(id);
    }

    public void deleteOne(Long id){
        repository.deleteById(id);
    }

}
