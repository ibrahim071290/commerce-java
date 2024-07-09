package com.commerce.marketplace.controllers;


import com.commerce.marketplace.entities.InvoiceDetalle;
import com.commerce.marketplace.services.InvoiceDetallesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/invoiceDetalles")
public class InvoiceDetallesController {

    @Autowired private InvoiceDetallesService service;

    @PostMapping
    public ResponseEntity<InvoiceDetalle> create(@RequestBody InvoiceDetalle data){
        try {

            InvoiceDetalle invoiceDetalle = service.save(data);
            return new ResponseEntity<>(invoiceDetalle, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDetalle>> read(){
        try {
            List<InvoiceDetalle> invoiceDetalles = service.read();
            return ResponseEntity.ok(invoiceDetalles);
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
    public ResponseEntity<InvoiceDetalle> readById(@PathVariable Long id) {
        try {
            Optional<InvoiceDetalle> invoiceDetalle = service.readOne(id);
            if (invoiceDetalle.isPresent()) {
                return ResponseEntity.ok(invoiceDetalle.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
