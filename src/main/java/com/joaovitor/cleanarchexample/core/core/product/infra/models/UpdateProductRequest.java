package com.joaovitor.cleanarchexample.core.core.product.infra.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record UpdateProductRequest(
        @JsonProperty("description") String description,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("is_active") Boolean active
) {
}
