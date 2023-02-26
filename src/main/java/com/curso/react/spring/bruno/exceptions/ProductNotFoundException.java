package com.curso.react.spring.bruno.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super("The product you entered does not exist in our system.");
    }
}
