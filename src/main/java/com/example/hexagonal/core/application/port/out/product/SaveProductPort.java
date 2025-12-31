package com.example.hexagonal.core.application.port.out.product;

import com.example.hexagonal.core.domain.product.Product;

public interface SaveProductPort {
    Product save(Product product);
}
