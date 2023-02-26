package com.curso.react.spring.bruno.repository;

import com.curso.react.spring.bruno.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
