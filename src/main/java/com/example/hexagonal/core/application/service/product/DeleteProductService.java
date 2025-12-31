package com.example.hexagonal.core.application.service.product;

import com.example.hexagonal.core.application.port.in.product.DeleteProductUseCase;
import com.example.hexagonal.core.application.port.out.product.DeleteProductPort;
import com.example.hexagonal.core.application.port.out.product.LoadProductPort;
import com.example.hexagonal.core.domain.product.Product;
import com.example.hexagonal.core.domain.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {
    private final LoadProductPort loadProductPort;
    private final DeleteProductPort deleteProductPort;

    public void deleteProduct(Long id) {
        Product product = loadProductPort.loadProduct(id).orElseThrow(ProductNotFoundException::new);
        deleteProductPort.deleteProduct(id);
    }
}
