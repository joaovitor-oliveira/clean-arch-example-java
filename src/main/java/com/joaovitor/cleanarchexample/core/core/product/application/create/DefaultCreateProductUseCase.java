package com.joaovitor.cleanarchexample.core.core.product.application.create;

import com.joaovitor.cleanarchexample.core.core.product.domain.Product;
import com.joaovitor.cleanarchexample.core.core.product.domain.ProductGateway;

public class DefaultCreateProductUseCase extends CreateProductUseCase {

    private final ProductGateway productGateway;

    public DefaultCreateProductUseCase(final ProductGateway productGateway) {
        this.productGateway = productGateway;
    }


    @Override
    public CreateProductOutput execute(final CreateProductCommand aCommand) {
        final var aDescription = aCommand.description();
        final var aPrice = aCommand.price();
        final var isActive = aCommand.isActive();

        final var aProduct = Product.newProduct(aDescription, aPrice, isActive);
        productGateway.create(aProduct);
        return CreateProductOutput.from(aProduct);
    }
}
