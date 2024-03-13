package com.joaovitor.cleanarchexample.application.product.create;

import com.joaovitor.cleanarchexample.core.core.product.application.create.CreateProductCommand;
import com.joaovitor.cleanarchexample.core.core.product.application.create.DefaultCreateProductUseCase;
import com.joaovitor.cleanarchexample.core.core.product.domain.Product;
import com.joaovitor.cleanarchexample.core.core.product.domain.ProductGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class CreateProductUseCaseTest {

    private DefaultCreateProductUseCase useCase;
    private ProductGateway productGateway;
    protected List<Object> getMocks() {
        return List.of(productGateway);
    }

    @Test
    public void givenAValidCommand_whenCallsCreateProduct_shouldReturnProductId() {
        final var expectedDescription = "Creatine creapure";
        final var expectedPrice = new BigDecimal("85.00");
        final var expectedActive = true;

        final var aCommand = CreateProductCommand.with(expectedDescription, expectedPrice, expectedActive);

        when(productGateway.create(any()))
                .thenAnswer(returnsFirstArg());

        final var output = useCase.execute(aCommand);

        Assertions.assertNotNull(output);
        Assertions.assertNotNull(output.id());

        Mockito.verify(productGateway, times(1))
                .create(argThat(product ->
                        Objects.equals(expectedDescription, product.getDescription()) &&
                        Objects.equals(expectedPrice, product.getPrice()) &&
                        Objects.equals(expectedActive, product.isActive()) &&
                        Objects.nonNull(product.getCreatedAt()) &&
                        Objects.nonNull(product.getUpdatedAt()) &&
                        Objects.isNull(product.getDeletedAt())
        ));
    }
}
