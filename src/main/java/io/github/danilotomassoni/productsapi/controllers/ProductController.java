package io.github.danilotomassoni.productsapi.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
