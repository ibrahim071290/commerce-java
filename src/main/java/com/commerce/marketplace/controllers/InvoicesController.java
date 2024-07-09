package com.commerce.marketplace.controllers;

import com.commerce.marketplace.entities.Invoice;
import com.commerce.marketplace.services.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/invoices")
public class InvoicesController {

    @Autowired private InvoicesService service;

    @PostMapping
    public ResponseEntity<Invoice> create(@RequestBody Invoice data){
        try {

            Invoice invoice = service.save(data);
            return new ResponseEntity<>(invoice, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> read(){
        try {
            List<Invoice> invoices = service.read();
            return ResponseEntity.ok(invoices);
            //metodo isEmpty
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id){
        try {
            service.deleteOne(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> readById(@PathVariable Long id) {
        try {
            Optional<Invoice> invoice = service.readOne(id);
            if (invoice.isPresent()) {
                return ResponseEntity.ok(invoice.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
