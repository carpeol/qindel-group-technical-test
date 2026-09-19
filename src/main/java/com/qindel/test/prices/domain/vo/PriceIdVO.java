package com.qindel.test.prices.domain.vo;

import com.qindel.test.prices.domain.exception.InvalidField;
import lombok.Getter;

@Getter
public class PriceIdVO extends ValueObject<Long> {

    private static final String FIELD_NAME = "priceId";


    public PriceIdVO(Long value) {
        super(validate(value));
    }

    private static Long validate(Long value) {
        if (value == null) throw new InvalidField(FIELD_NAME, "null");
        if (value <= 0) throw new InvalidField(FIELD_NAME, String.valueOf(value));
        return value;
    }
}
