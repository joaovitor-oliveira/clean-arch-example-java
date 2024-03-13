package com.joaovitor.cleanarchexample.core.core.product.infra;

import com.joaovitor.cleanarchexample.core.core.product.domain.Product;
import com.joaovitor.cleanarchexample.core.core.product.domain.ProductGateway;
import com.joaovitor.cleanarchexample.core.core.product.domain.ProductID;
import com.joaovitor.cleanarchexample.core.core.product.infra.persistence.ProductJpaEntity;
import com.joaovitor.cleanarchexample.core.core.product.infra.persistence.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductH2Gateway implements ProductGateway {

    private final ProductRepository repository;

    public ProductH2Gateway(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product aProduct) {
        return save(aProduct);
    }

    @Override
    public void deletedById(ProductID anId) {

    }

    @Override
    public Optional<Product> findById(ProductID anId) {
        return Optional.empty();
    }

    @Override
    public Product update(Product aProduct) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<ProductID> existsByIds(Iterable<ProductID> ids) {
        return null;
    }

    private Product save(final Product aProduct) {
        return this.repository.save(ProductJpaEntity.from(aProduct)).toAggregate();
    }
}
