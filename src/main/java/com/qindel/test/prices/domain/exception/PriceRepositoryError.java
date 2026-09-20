package com.qindel.test.prices.domain.exception;

public class PriceRepositoryError extends Exception {
    public PriceRepositoryError(String message, Exception exception) {
        super(message, exception);
    }
}
