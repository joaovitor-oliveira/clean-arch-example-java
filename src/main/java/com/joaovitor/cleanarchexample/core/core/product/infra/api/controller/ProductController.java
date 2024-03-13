package com.joaovitor.cleanarchexample.core.core.product.infra.api.controller;

import com.joaovitor.cleanarchexample.core.core.product.application.create.CreateProductCommand;
import com.joaovitor.cleanarchexample.core.core.product.application.create.CreateProductUseCase;
import com.joaovitor.cleanarchexample.core.core.product.infra.api.ProductAPI;
import com.joaovitor.cleanarchexample.core.core.product.infra.models.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ProductController implements ProductAPI {

    private final CreateProductUseCase createProductUseCase;

    public ProductController(final CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = Objects.requireNonNull(createProductUseCase);
    }

    @Override
    public ResponseEntity<?> createProduct(CreateProductRequest input) {
        final var aCommand = CreateProductCommand.with(
                input.description(),
                input.price(),
                input.active() == null ? true : input.active()
        );

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(createProductUseCase.execute(aCommand));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
