package com.example.hexagonal.adapter.in.web.domain.product;

import com.example.hexagonal.adapter.in.web.domain.product.dto.request.ProductCreateRequest;
import com.example.hexagonal.adapter.in.web.domain.product.dto.request.ProductUpdateRequest;
import com.example.hexagonal.adapter.in.web.domain.product.dto.response.ProductCreateResponse;
import com.example.hexagonal.adapter.in.web.domain.product.dto.response.ProductGetDetailResponse;
import com.example.hexagonal.adapter.in.web.domain.product.dto.response.ProductUpdateResponse;
import com.example.hexagonal.core.application.port.in.product.*;
import com.example.hexagonal.core.domain.product.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final GetProductDetailQuery getProductDetailQuery;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @PostMapping
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductCreateRequest request) {
        CreateProductCommand command = ProductWebMapper.mapToCreateCommand(request);
        Product product = createProductUseCase.create(command);
        ProductCreateResponse response = ProductWebMapper.mapToCreateResponse(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/products/" + product.getId())
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGetDetailResponse> getProduct(@PathVariable Long id) {
        Product product = getProductDetailQuery.getProduct(id);
        ProductGetDetailResponse response = ProductWebMapper.mapToGetDetailResponse(product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductUpdateResponse> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductUpdateRequest request) {
        UpdateProductCommand command = ProductWebMapper.mapToUpdateCommand(request, id);
        Product product = updateProductUseCase.update(command);
        ProductUpdateResponse response = ProductWebMapper.mapToUpdateResponse(product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        deleteProductUseCase.deleteProduct(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
