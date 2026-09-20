package com.qindel.test.prices.infrastructure.inbound.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qindel.test.prices.application.find.ApplicablePriceResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ApplicablePriceDTO(
        @Schema(example = "1")
        Long productId,
        @Schema(example = "1")
        Long brandId,
        @Schema(example = "1")
        Long priceId,
        @JsonFormat(pattern = PriceApiDateTime.PATTERN)
        @Schema(type = "string", pattern = PriceApiDateTime.REGEX,
                example = PriceApiDateTime.EXAMPLE)
        LocalDateTime startDate,
        @JsonFormat(pattern = PriceApiDateTime.PATTERN)
        @Schema(type = "string", pattern = PriceApiDateTime.REGEX,
                example = PriceApiDateTime.EXAMPLE)
        LocalDateTime endDate,
        BigDecimal priceAmount,
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
