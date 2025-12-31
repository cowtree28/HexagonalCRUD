package com.example.hexagonal.core.application.port.in.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateProductCommand {
    private Long id;
    private String name;
    private double price;
    private String description;
}
