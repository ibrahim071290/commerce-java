package com.commerce.marketplace.controllers;

import com.commerce.marketplace.entities.Client;
import com.commerce.marketplace.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/clients")
public class ClientsController {

    @Autowired private ClientsService service;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client data){
        try {

            Client client = service.save(data);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Client>> read(){
        try {
            List<Client> clients = service.read();
            return ResponseEntity.ok(clients);
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
    public ResponseEntity<Client> readById(@PathVariable Long id) {
        try {
            Optional<Client> client = service.readOne(id);
            if (client.isPresent()) {
                return ResponseEntity.ok(client.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
