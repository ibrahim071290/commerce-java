package com.commerce.marketplace.services;

import com.commerce.marketplace.entities.Product;
import com.commerce.marketplace.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired private ProductsRepository repository;

    public Product save(Product product){
        return repository.save(product);
    }

    public List<Product> read(){
        return  repository.findAll();
    }

    public Optional<Product> readOne(Long id){
        return  repository.findById(id);
    }

    public void deleteOne(Long id){
        repository.deleteById(id);
    }

}
