package io.github.danilotomassoni.productsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.danilotomassoni.productsapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
