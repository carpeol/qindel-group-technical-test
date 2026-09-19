package com.qindel.test.prices.application.find;

import java.time.LocalDateTime;

public record ApplicablePriceResponse(
        Long productId,
        Long brandId,
        Long priceId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Double priceAmount,
        String currency
) {
}
