package io.github.danilotomassoni.productsapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.danilotomassoni.productsapi.entities.Product;
import io.github.danilotomassoni.productsapi.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product entity) {
        return repository.saveAndFlush(entity);
    }
}
