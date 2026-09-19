package com.qindel.test.prices.domain.vo;

import com.qindel.test.prices.domain.exception.InvalidField;
import lombok.Getter;

@Getter
public class PriceVO extends ValueObject<Double> {

    private static final String FIELD_NAME = "price";

    public PriceVO(Double value) {
        super(validate(value));
    }

    private static Double validate(Double value) {
        if (value == null) throw new InvalidField(FIELD_NAME, "null");
        if (value < 0) throw new InvalidField(FIELD_NAME, String.valueOf(value));
        return value;
    }
}

