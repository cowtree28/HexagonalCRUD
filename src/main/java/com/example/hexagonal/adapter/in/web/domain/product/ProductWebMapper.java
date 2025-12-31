package com.example.hexagonal.adapter.in.web.domain.product;

import com.example.hexagonal.adapter.in.web.domain.product.dto.request.ProductCreateRequest;
import com.example.hexagonal.adapter.in.web.domain.product.dto.request.ProductUpdateRequest;
import com.example.hexagonal.adapter.in.web.domain.product.dto.response.ProductCreateResponse;
import com.example.hexagonal.adapter.in.web.domain.product.dto.response.ProductGetDetailResponse;
import com.example.hexagonal.adapter.in.web.domain.product.dto.response.ProductUpdateResponse;
import com.example.hexagonal.core.application.port.in.product.CreateProductCommand;
import com.example.hexagonal.core.application.port.in.product.UpdateProductCommand;
import com.example.hexagonal.core.domain.product.Product;

public class ProductWebMapper {
    static CreateProductCommand mapToCreateCommand(ProductCreateRequest dto) {
        return new CreateProductCommand(dto.name(), dto.description(), dto.price());
    }

    static ProductCreateResponse mapToCreateResponse(Product product) {
        return ProductCreateResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    static ProductGetDetailResponse mapToGetDetailResponse(Product product) {
        return ProductGetDetailResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    static ProductUpdateResponse mapToUpdateResponse(Product product) {
        return ProductUpdateResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    static UpdateProductCommand mapToUpdateCommand(ProductUpdateRequest dto, Long id) {
        return new UpdateProductCommand(id, dto.name(), dto.price(), dto.description());
    }
}
