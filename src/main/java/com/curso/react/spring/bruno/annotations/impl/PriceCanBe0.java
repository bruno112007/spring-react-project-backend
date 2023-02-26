package com.curso.react.spring.bruno.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceCanBe0 implements ConstraintValidator<com.curso.react.spring.bruno.annotations.PriceCanBe0, Double> {
    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        return aDouble > 0;
    }

    @Override
    public void initialize(com.curso.react.spring.bruno.annotations.PriceCanBe0 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
