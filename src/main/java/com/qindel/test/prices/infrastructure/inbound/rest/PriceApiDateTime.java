package com.qindel.test.prices.infrastructure.inbound.rest;

/**
 * Date representation exposed by the REST adapter.
 */
public final class PriceApiDateTime {

    public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String REGEX = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}";
    public static final String EXAMPLE = "2020-06-14T16:00:00.000";

    private PriceApiDateTime() {
    }
}
