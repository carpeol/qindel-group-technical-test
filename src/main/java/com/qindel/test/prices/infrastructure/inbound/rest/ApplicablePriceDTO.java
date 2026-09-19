package com.qindel.test.prices.infrastructure.inbound.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qindel.test.prices.application.find.ApplicablePriceResponse;
import com.qindel.test.prices.domain.vo.DateTimeFormats;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record ApplicablePriceDTO(
        @Schema(example = "1")
        Long productId,
        @Schema(example = "1")
        Long brandId,
        @Schema(example = "1")
        Long priceId,
        @JsonFormat(pattern = DateTimeFormats.PRICE_DATE_PATTERN)
        @Schema(type = "string", pattern = DateTimeFormats.PRICE_DATE_REGEX,
                example = DateTimeFormats.PRICE_DATE_EXAMPLE)
        LocalDateTime startDate,
        @JsonFormat(pattern = DateTimeFormats.PRICE_DATE_PATTERN)
        @Schema(type = "string", pattern = DateTimeFormats.PRICE_DATE_REGEX,
                example = DateTimeFormats.PRICE_DATE_EXAMPLE)
        LocalDateTime endDate,
        Double priceAmount,
        String currency
) {

    public static ApplicablePriceDTO from(ApplicablePriceResponse response) {
        return new ApplicablePriceDTO(
                response.productId(),
                response.brandId(),
                response.priceId(),
                response.startDate(),
                response.endDate(),
                response.priceAmount(),
                response.currency()
        );
    }
}
