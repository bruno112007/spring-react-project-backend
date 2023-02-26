package com.curso.react.spring.bruno.service;

import com.curso.react.spring.bruno.entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    void delete(Product product);
    List<Product> findAll(Example example);
}
