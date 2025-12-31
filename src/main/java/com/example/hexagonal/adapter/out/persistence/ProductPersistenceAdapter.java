package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.core.application.port.out.product.DeleteProductPort;
import com.example.hexagonal.core.application.port.out.product.LoadProductPort;
import com.example.hexagonal.core.application.port.out.product.SaveProductPort;
import com.example.hexagonal.core.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements SaveProductPort, LoadProductPort, DeleteProductPort {
    private final ProductJpaRepository repository;

    @Override
    public Optional<Product> loadProduct(Long id) {
        return repository.findById(id).map(ProductPersistenceMapper::toDomain);
    }

    @Override
    public Product save(Product product) {
        return ProductPersistenceMapper.toDomain(repository.save(ProductPersistenceMapper.toEntity(product)));
    }


    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
