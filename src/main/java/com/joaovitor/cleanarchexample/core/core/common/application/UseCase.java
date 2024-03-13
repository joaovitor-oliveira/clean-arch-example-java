package com.joaovitor.cleanarchexample.core.core.common.application;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN anIn);
}
