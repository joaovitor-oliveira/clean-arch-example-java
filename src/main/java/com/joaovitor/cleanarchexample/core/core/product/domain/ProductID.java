package com.joaovitor.cleanarchexample.core.core.product.domain;

import com.joaovitor.cleanarchexample.core.core.common.domain.Identifier;
import com.joaovitor.cleanarchexample.core.core.common.utils.IdUtils;

import java.util.Objects;

public class ProductID extends Identifier {

    private final String value;

    private ProductID(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static ProductID from(final String anID) {
        return new ProductID(anID);
    }

    public static ProductID unique() {
        return ProductID.from(IdUtils.uuid());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID that = (ProductID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
