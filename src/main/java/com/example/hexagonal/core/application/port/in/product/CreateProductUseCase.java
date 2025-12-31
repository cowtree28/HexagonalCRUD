package com.example.hexagonal.core.application.port.in.product;

import com.example.hexagonal.core.domain.product.Product;

public interface CreateProductUseCase {
    Product create(CreateProductCommand command);
}
