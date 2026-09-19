package com.qindel.test.prices.domain.vo;

import java.time.format.DateTimeFormatter;

public final class DateTimeFormats {

    public static final String PRICE_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    /** Regular expression used by the OpenAPI schema (not a DateTimeFormatter pattern). */
    public static final String PRICE_DATE_REGEX =
            "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}";
    public static final String PRICE_DATE_EXAMPLE = "2020-06-14T16:00:00.000";
    public static final DateTimeFormatter PRICE_DATE_FORMATTER =
            DateTimeFormatter.ofPattern(PRICE_DATE_PATTERN);

    private DateTimeFormats() {
    }
}
