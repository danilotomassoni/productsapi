package io.github.danilotomassoni.productsapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.danilotomassoni.productsapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

}
