package com.joaovitor.cleanarchexample.core.core.product.application.create;

import java.math.BigDecimal;

public record CreateProductCommand(
        String description,
        BigDecimal price,
        boolean isActive
) {
    public static  CreateProductCommand with(
            final String aDescription,
            final BigDecimal aPrice,
            final boolean isActive
    ) {
        return new CreateProductCommand(aDescription, aPrice, isActive);
    }
}
