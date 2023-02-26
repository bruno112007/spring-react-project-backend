package com.curso.react.spring.bruno.service.impl;

import com.curso.react.spring.bruno.entities.Product;
import com.curso.react.spring.bruno.repository.ProductRepository;
import com.curso.react.spring.bruno.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired private ProductRepository repository;
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public List<Product> findAll(Example example) {
        return repository.findAll(example);
    }
}
