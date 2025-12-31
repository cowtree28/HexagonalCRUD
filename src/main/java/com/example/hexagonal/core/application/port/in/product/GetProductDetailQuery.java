package com.example.hexagonal.core.application.port.in.product;

import com.example.hexagonal.core.domain.product.Product;

public interface GetProductDetailQuery {
    Product getProduct(Long id);
}