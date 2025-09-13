package io.github.danilotomassoni.productsapi.services;

import java.util.Optional;

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

    public Optional<Product> findById(Integer id){
        return repository.findById(id);
    }
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    public Product update(Integer id, Product entity){
        Product product = findById(id).get();
         
        product.setName(entity.getName().isEmpty() ? product.getName():entity.getName());
        product.setDescription(entity.getDescription().isEmpty() ? product.getDescription():entity.getDescription());
        product.setPrice(entity.getPrice() != null ? entity.getPrice():0);
        
        return repository.save(product);
    }
}
