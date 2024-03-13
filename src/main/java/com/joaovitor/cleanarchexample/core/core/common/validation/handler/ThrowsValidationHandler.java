package com.joaovitor.cleanarchexample.core.core.common.validation.handler;

import com.joaovitor.cleanarchexample.core.core.common.exceptions.DomainException;
import com.joaovitor.cleanarchexample.core.core.common.validation.Error;
import com.joaovitor.cleanarchexample.core.core.common.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(List.of(anError));
    }

    @Override
    public ValidationHandler append(ValidationHandler aHandler) {
        throw DomainException.with(aHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(List.of(new Error(ex.getMessage())));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
