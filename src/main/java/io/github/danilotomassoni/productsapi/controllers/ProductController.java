package io.github.danilotomassoni.productsapi.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.danilotomassoni.productsapi.entities.Product;

@RestController
@RequestMapping("products")
public class ProductController {

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        URI uri = URI.create("/products/" + product.getId());
        return ResponseEntity.created(uri).body(product);
    }
}
