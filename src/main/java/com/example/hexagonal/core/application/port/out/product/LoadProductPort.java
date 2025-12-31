package com.example.hexagonal.core.application.port.out.product;

import com.example.hexagonal.core.domain.product.Product;

import java.util.Optional;

public interface LoadProductPort {
    Optional<Product> loadProduct(Long id);
}
