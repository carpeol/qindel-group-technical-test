package com.qindel.test.prices.domain.vo;

import com.qindel.test.prices.domain.exception.InvalidField;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StartDateVO extends ValueObject<LocalDateTime> {

    private static final String FIELD_NAME = "startDate";

    public StartDateVO(LocalDateTime value) {
        super(validate(value));
    }

    private static LocalDateTime validate(LocalDateTime value) {
        if (value == null) throw new InvalidField(FIELD_NAME, "null");
        return value;
    }

    @Override
    public String toString() {
        return this.value().format(DateTimeFormats.PRICE_DATE_FORMATTER);
    }
}
