package com.joaovitor.cleanarchexample.core.core.product.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductJpaEntity, String> {
}
