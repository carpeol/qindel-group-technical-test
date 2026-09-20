package com.qindel.test.prices.domain.vo;

import com.qindel.test.prices.domain.exception.InvalidField;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PriceVO extends ValueObject<BigDecimal> {

    private static final String FIELD_NAME = "price";

    public PriceVO(BigDecimal value) {
        super(validate(value));
    }

    private static BigDecimal validate(BigDecimal value) {
        if (value == null) throw new InvalidField(FIELD_NAME, "null");
        if (value.signum() < 0) throw new InvalidField(FIELD_NAME, String.valueOf(value));
        return value;
    }
}
