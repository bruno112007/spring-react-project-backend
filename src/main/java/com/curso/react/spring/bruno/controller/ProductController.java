package com.curso.react.spring.bruno.controller;

import com.curso.react.spring.bruno.dtos.ProductDTO;
import com.curso.react.spring.bruno.entities.Product;
import com.curso.react.spring.bruno.exceptions.ProductNotFoundException;
import com.curso.react.spring.bruno.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired private ProductService service;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody@Valid ProductDTO dto){
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Product product = service
                .findById(id)
                .orElseThrow(ProductNotFoundException::new);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody@Valid ProductDTO dto, @PathVariable Integer id){
        Product product = service
                .findById(id)
                .orElseThrow(ProductNotFoundException::new);
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Product product = service
                .findById(id)
                .orElseThrow(ProductNotFoundException::new);
        service.delete(product);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted.");
    }

    @GetMapping("/filter")
    public List<Product> listFilter(Product product){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(product, matcher);
        List<Product> list = service.findAll(example);
        return list;
    }
}
