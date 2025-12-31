package com.example.hexagonal.core.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;

    public void updateInfo(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
