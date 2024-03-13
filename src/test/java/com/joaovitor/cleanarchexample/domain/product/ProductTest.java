package com.joaovitor.cleanarchexample.domain.product;


import com.joaovitor.cleanarchexample.core.core.product.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductTest {

    @Test
    public void givenAValidParams_whenCallNewProduct_thenInstantiateAProduct() {
        final var expectedDescription = "Creatine Creapure";
        final var expectedPrice = 85.00;
        final var expectedActive = true;

        final var actualProduct = Product.newProduct(expectedDescription, BigDecimal.valueOf(expectedPrice), expectedActive);

        Assertions.assertNotNull(actualProduct);
        Assertions.assertNotNull(actualProduct.getId());
        Assertions.assertEquals(expectedDescription, actualProduct.getDescription());
        Assertions.assertEquals(BigDecimal.valueOf(expectedPrice), actualProduct.getPrice());
        Assertions.assertEquals(expectedActive, actualProduct.isActive());
        Assertions.assertNotNull(actualProduct.getCreatedAt());
        Assertions.assertNotNull(actualProduct.getUpdatedAt());
        Assertions.assertNull(actualProduct.getDeletedAt());
    }

    @Test
    public void givenAnInvalidNullDescription() {
        final var expectedDescription = "Creatine Creapure";
        final var expectedPrice = 85.00;
        final var expectedActive = true;

        final var actualProduct = Product.newProduct(expectedDescription, BigDecimal.valueOf(expectedPrice), expectedActive);

        Assertions.assertNotNull(actualProduct);
        Assertions.assertNotNull(actualProduct.getId());
        Assertions.assertEquals(expectedDescription, actualProduct.getDescription());
        Assertions.assertEquals(BigDecimal.valueOf(expectedPrice), actualProduct.getPrice());
        Assertions.assertEquals(expectedActive, actualProduct.isActive());
        Assertions.assertNotNull(actualProduct.getCreatedAt());
        Assertions.assertNotNull(actualProduct.getUpdatedAt());
        Assertions.assertNull(actualProduct.getDeletedAt());
    }
}
