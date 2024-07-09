package com.commerce.marketplace.services;

import com.commerce.marketplace.entities.Client;
import com.commerce.marketplace.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    @Autowired private ClientsRepository repository;

    public Client save(Client client){
        return repository.save(client);
    }

    public List<Client> read(){
        return  repository.findAll();
    }

    public Optional<Client> readOne(Long id){
        return  repository.findById(id);
    }

    public void deleteOne(Long id){
        repository.deleteById(id);
    }
}
