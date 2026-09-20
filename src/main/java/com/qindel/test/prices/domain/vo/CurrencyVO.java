package com.qindel.test.prices.domain.vo;

import com.qindel.test.prices.domain.exception.InvalidField;
import lombok.Getter;

@Getter
public class CurrencyVO extends ValueObject<String> {

    private static final String FIELD_NAME = "currency";

    public CurrencyVO(String value) {
        super(validate(value));
    }

    private static String validate(String value) {
        if (value == null) throw new InvalidField(FIELD_NAME, "null");
        String normalizedValue = value.trim().toUpperCase();
        if (!normalizedValue.matches("[A-Z]{3}")) throw new InvalidField(FIELD_NAME, value);
        return normalizedValue;
    }
}
