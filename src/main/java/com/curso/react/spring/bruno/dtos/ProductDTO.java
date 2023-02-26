package com.curso.react.spring.bruno.dtos;

import com.curso.react.spring.bruno.annotations.PriceCanBe0;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductDTO {
    @NotBlank(message = "This product needs a name.")
    private String name;
    @NotBlank(message = "The product needs a brand.")
    private String brand;
    @NotNull(message = "The product needs a price.")
    @PriceCanBe0(message = "Price cannot be 0 or less.")
    private Double price;
}
