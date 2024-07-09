package com.commerce.marketplace.controllers;


import com.commerce.marketplace.entities.Product;
import com.commerce.marketplace.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

    @Autowired private ProductsService service;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product data){
        try {

            Product product = service.save(data);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> read(){
        try {
            List<Product> products = service.read();
            return ResponseEntity.ok(products);
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
    public ResponseEntity<Product> readById(@PathVariable Long id) {
        try {
            Optional<Product> product = service.readOne(id);
            if (product.isPresent()) {
                return ResponseEntity.ok(product.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
