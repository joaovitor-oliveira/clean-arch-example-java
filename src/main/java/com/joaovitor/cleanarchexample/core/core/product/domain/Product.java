package com.joaovitor.cleanarchexample.core.core.product.domain;

import com.joaovitor.cleanarchexample.core.core.common.domain.AggregateRoot;
import com.joaovitor.cleanarchexample.core.core.common.utils.InstantUtils;
import com.joaovitor.cleanarchexample.core.core.common.validation.ValidationHandler;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Product extends AggregateRoot<ProductID> implements Cloneable {

    private String description;
    private BigDecimal price;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Product(
            final ProductID anId,
            final String aDescription,
            final BigDecimal aPrice,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {
        super(anId);
        this.description = aDescription;
        this.price = aPrice;
        this.active = isActive;
        this.createdAt = Objects.requireNonNull(aCreationDate, "'createdAt' should not be null");
        this.updatedAt = Objects.requireNonNull(aUpdateDate, "'updatedAt' should not be null");
        this.deletedAt = aDeleteDate;
    }

    public static Product newProduct(final String aDescription, final BigDecimal aPrice, final boolean isActive) {
        final var id = ProductID.unique();
        final var now = InstantUtils.now();
        final var deletedAt = isActive ? null : now;

        return new Product(id, aDescription, aPrice, isActive, now, now, deletedAt);
    }

    public static Product with(
            final ProductID anId,
            final String aDescription,
            final BigDecimal aPrice,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {
        return new Product(
                anId,
                aDescription,
                aPrice,
                isActive,
                aCreationDate,
                aUpdateDate,
                aDeleteDate
        );
    }

    public static Product with(final Product aProduct) {
        return with(
                aProduct.getId(),
                aProduct.getDescription(),
                aProduct.getPrice(),
                aProduct.isActive(),
                aProduct.getCreatedAt(),
                aProduct.getUpdatedAt(),
                aProduct.getDeletedAt()
        );
    }

    public Product activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Product deactivate() {
        if(getDeletedAt() == null) {
            this.deletedAt = InstantUtils.now();
        }

        this.active = false;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Product update(final String aDescription, final BigDecimal aPrice, final boolean isActive) {
        if(isActive) {
            activate();
        } else {
            deactivate();
        }

        this.description = aDescription;
        this.price = aPrice;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    @Override
    public void validate(ValidationHandler handler) {

    }

    public ProductID getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
