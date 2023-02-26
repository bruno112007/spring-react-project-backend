package com.curso.react.spring.bruno.exceptions;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    @Getter
    private List<String> error;

    public ApiErrors(String msg){
        this.error = Arrays.asList(msg);
    }

    public ApiErrors(List<String> errors){
        this.error = errors;
    }
}
