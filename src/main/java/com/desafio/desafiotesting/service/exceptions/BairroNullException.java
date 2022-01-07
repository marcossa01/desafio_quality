package com.desafio.desafiotesting.service.exceptions;

import java.util.function.Supplier;

public class BairroNullException extends RuntimeException {
    private static final long serialVersionUID = -2450764264040582859L;

    public BairroNullException(String message) {
        super(message);
    }
}
