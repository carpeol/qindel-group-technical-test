package com.qindel.test.prices.domain.vo;

import com.qindel.test.prices.domain.exception.InvalidField;
import lombok.Getter;

@Getter
public class ProductIdVO extends ValueObject<Long> {

    private static final String FIELD_NAME = "productId";


    public ProductIdVO(Long value) {
        super(validate(value));
    }

    private static Long validate(Long value) {
        if (value == null) throw new InvalidField(FIELD_NAME, "null");
        if (value <= 0) throw new InvalidField(FIELD_NAME, String.valueOf(value));
        return value;
    }
}
