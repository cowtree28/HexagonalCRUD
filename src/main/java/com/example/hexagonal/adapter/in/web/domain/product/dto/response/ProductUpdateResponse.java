package com.example.hexagonal.adapter.in.web.domain.product.dto.response;

import lombok.Builder;

@Builder
public record ProductUpdateResponse(
    Long id,
    String name,
    String description,
    Double price
) { }
