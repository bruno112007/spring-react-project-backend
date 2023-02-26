package com.curso.react.spring.bruno.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.DecimalMin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = com.curso.react.spring.bruno.annotations.impl.PriceCanBe0.class)
public @interface PriceCanBe0 {
    String message() default "This price is invalid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
