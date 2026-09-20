package com.qindel.test.prices.domain.vo;

import java.time.format.DateTimeFormatter;

public final class DateTimeFormats {

    public static final DateTimeFormatter PRICE_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    private DateTimeFormats() {
    }
}
