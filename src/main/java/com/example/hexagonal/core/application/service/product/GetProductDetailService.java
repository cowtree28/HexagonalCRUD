package com.example.hexagonal.core.application.service.product;

import com.example.hexagonal.core.application.port.in.product.GetProductDetailQuery;
import com.example.hexagonal.core.application.port.out.product.LoadProductPort;
import com.example.hexagonal.core.domain.product.Product;
import com.example.hexagonal.core.domain.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductDetailService implements GetProductDetailQuery {
    private final LoadProductPort loadProductPort;

    @Override
    public Product getProduct(Long id) {
        return loadProductPort.loadProduct(id).orElseThrow(ProductNotFoundException::new);
    }
}
