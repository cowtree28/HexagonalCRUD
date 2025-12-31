package com.example.hexagonal.core.domain.product.exception;

import com.example.hexagonal.core.common.exception.BaseException;

public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException() {
        super(ProductErrorCode.PRODUCT_NOT_FOUND);
    }
}
