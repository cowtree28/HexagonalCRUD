package com.example.hexagonal.adapter.in.web.domain.product.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductCreateRequest(
        @Size(max = 255, message = "길이는 255자 이하여야합니다.")
        @NotBlank(message = "이름은 비어있을수 없습니다")
        String name,

        @Min(value = 0, message = "가격은 0보다 커야합니다")
        @NotNull
        Double price,

        @Size(min = 1, max = 255, message = "길이는 255자 이하여야합니다.")
        String description)
{ }
