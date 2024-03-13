package com.joaovitor.cleanarchexample.core.core.product.infra.configuration;

import com.joaovitor.cleanarchexample.core.core.product.application.create.CreateProductUseCase;
import com.joaovitor.cleanarchexample.core.core.product.application.create.DefaultCreateProductUseCase;
import com.joaovitor.cleanarchexample.core.core.product.domain.ProductGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCaseConfig {

    private final ProductGateway productGateway;

    public ProductUseCaseConfig(final ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Bean
    public CreateProductUseCase createProductUseCase() {
        return new DefaultCreateProductUseCase(productGateway);
    }
}
