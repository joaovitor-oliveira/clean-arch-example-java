package com.joaovitor.cleanarchexample.core.core.product.domain;

import com.joaovitor.cleanarchexample.core.core.common.validation.Error;
import com.joaovitor.cleanarchexample.core.core.common.validation.ValidationHandler;
import com.joaovitor.cleanarchexample.core.core.common.validation.Validator;

public class ProductValidator extends Validator {

    private final Product product;

    public ProductValidator(final Product aProduct, final ValidationHandler aHandler) {
        super(aHandler);
        this.product = aProduct;
    }


    @Override
    public void validate() {
        if(this.product.getDescription() == null) {
            this.validationHandler().append(new Error("'description' should not be null"));
        }
    }
}
