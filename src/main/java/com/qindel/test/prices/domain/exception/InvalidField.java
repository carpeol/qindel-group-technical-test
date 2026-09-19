package com.qindel.test.prices.domain.exception;

public class InvalidField extends RuntimeException {
    public InvalidField(String field, String value) {
        super("Field " + field + " has invalid value: " + value
        );
    }
}
