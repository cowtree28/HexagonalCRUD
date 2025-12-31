package com.example.hexagonal.core.domain.product.exception;

import com.example.hexagonal.core.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductErrorCode implements ErrorCode {
    PRODUCT_NOT_FOUND("product not found", 404),;

    private final String message;
    private final int httpStatus;
}
