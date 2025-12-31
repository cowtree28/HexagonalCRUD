package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.adapter.out.persistence.entity.ProductJpaEntity;
import com.example.hexagonal.core.domain.product.Product;

public class ProductPersistenceMapper {
    public static ProductJpaEntity toEntity(Product product) {
        return ProductJpaEntity.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static Product toDomain(ProductJpaEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getDescription()
        );
    }
}
