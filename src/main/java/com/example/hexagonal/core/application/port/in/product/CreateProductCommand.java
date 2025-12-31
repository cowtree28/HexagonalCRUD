package com.example.hexagonal.core.application.port.in.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateProductCommand {
        private String name;
        private String description;
        private Double price;
}
