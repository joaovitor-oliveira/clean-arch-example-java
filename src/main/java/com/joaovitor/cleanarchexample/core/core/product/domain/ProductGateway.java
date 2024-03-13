package com.joaovitor.cleanarchexample.core.core.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductGateway {

    Product create(Product aProduct);

    void deletedById(ProductID anId);

    Optional<Product> findById(ProductID anId);

    Product update(Product aProduct);

    List<Product> findAll();

    List<ProductID> existsByIds(Iterable<ProductID> ids);
}
