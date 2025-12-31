package com.example.hexagonal.core.application.service.product;

import com.example.hexagonal.core.application.port.in.product.CreateProductCommand;
import com.example.hexagonal.core.application.port.in.product.CreateProductUseCase;
import com.example.hexagonal.core.application.port.out.product.SaveProductPort;
import com.example.hexagonal.core.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {
    private final SaveProductPort saveProductPort;

    @Override
    @Transactional
    public Product create(CreateProductCommand command) {
        Product product = new Product(null, command.getName(), command.getPrice(), command.getDescription());
        return saveProductPort.save(product);
    }
}
