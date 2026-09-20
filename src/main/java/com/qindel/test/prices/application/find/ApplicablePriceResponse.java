package com.qindel.test.prices.application.find;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ApplicablePriceResponse(
        Long productId,
        Long brandId,
        Long priceId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BigDecimal priceAmount,
        String currency
) {
}
