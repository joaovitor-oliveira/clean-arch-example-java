package com.joaovitor.cleanarchexample.core.core.product.application.create;

import com.joaovitor.cleanarchexample.core.core.product.domain.Product;

public record CreateProductOutput(String id) {

    public static CreateProductOutput from(final String anId) {
        return new CreateProductOutput(anId);
    }

    public static CreateProductOutput from(final Product aProduct) {
        return new CreateProductOutput(aProduct.getId().getValue());
    }
}
