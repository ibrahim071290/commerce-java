package com.commerce.marketplace.services;

import com.commerce.marketplace.entities.Invoice;
import com.commerce.marketplace.repositories.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoicesService {

    @Autowired private InvoicesRepository repository;

    public Invoice save(Invoice invoice){
        return repository.save(invoice);
    }

    public List<Invoice> read(){
        return  repository.findAll();
    }

    public Optional<Invoice> readOne(Long id){
        return  repository.findById(id);
    }

    public void deleteOne(Long id){
        repository.deleteById(id);
    }


}
