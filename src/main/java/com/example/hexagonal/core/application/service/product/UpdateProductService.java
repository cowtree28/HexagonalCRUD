package com.example.hexagonal.core.application.service.product;

import com.example.hexagonal.core.application.port.in.product.UpdateProductCommand;
import com.example.hexagonal.core.application.port.in.product.UpdateProductUseCase;
import com.example.hexagonal.core.application.port.out.product.LoadProductPort;
import com.example.hexagonal.core.application.port.out.product.SaveProductPort;
import com.example.hexagonal.core.domain.product.Product;
import com.example.hexagonal.core.domain.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {
    private final SaveProductPort saveProductPort;
    private final LoadProductPort loadProductPort;

    @Override
    @Transactional
    public Product update(UpdateProductCommand command) {
        Product product = loadProductPort.loadProduct(command.getId()).orElseThrow(ProductNotFoundException::new);
        product.updateInfo(command.getName(), command.getPrice(), command.getDescription());
        return saveProductPort.save(product);
    }
}
