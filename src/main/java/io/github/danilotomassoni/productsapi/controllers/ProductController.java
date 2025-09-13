package io.github.danilotomassoni.productsapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.danilotomassoni.productsapi.entities.Product;
import io.github.danilotomassoni.productsapi.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product savedProduct = service.save(product);
        URI uri = URI.create("/products/" + savedProduct.getId());
        return ResponseEntity.created(uri).body(savedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id).orElseThrow());
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping
    public ResponseEntity<Product> update(@RequestParam Integer id, @RequestBody Product product){

        return ResponseEntity.ok().body(service.update(id, product));
    }

    @GetMapping 
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> findByName(@RequestParam String name){
        return ResponseEntity.ok().body(service.findByName(name));
    }
    
}
