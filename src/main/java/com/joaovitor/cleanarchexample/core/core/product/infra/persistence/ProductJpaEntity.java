package com.joaovitor.cleanarchexample.core.core.product.infra.persistence;

import com.joaovitor.cleanarchexample.core.core.product.domain.Product;
import com.joaovitor.cleanarchexample.core.core.product.domain.ProductID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "Product")
@Table(name = "products")
@Data
@NoArgsConstructor
public class ProductJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME(6)")
    private Instant updatedAt;

    @Column(name = "deleted_at", columnDefinition = "DATETIME(6)")
    private Instant deletedAt;

    private ProductJpaEntity(
            final String id,
            final String description,
            final BigDecimal price,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static ProductJpaEntity from(final Product aProduct) {
        return new ProductJpaEntity(
                aProduct.getId().getValue(),
                aProduct.getDescription(),
                aProduct.getPrice(),
                aProduct.isActive(),
                aProduct.getCreatedAt(),
                aProduct.getUpdatedAt(),
                aProduct.getDeletedAt()
        );
    }

    public Product toAggregate() {
        return Product.with(
                ProductID.from(getId()),
                getDescription(),
                getPrice(),
                isActive(),
                getCreatedAt(),
                getUpdatedAt(),
                getDeletedAt()
        );
    }
}
