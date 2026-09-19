package com.qindel.test.prices.domain.model;

import com.qindel.test.prices.domain.vo.*;
import lombok.Getter;

public record Price(BrandIdVO brandId, StartDateVO startDate, EndDateVO endDate, PriceIdVO priceId,
                    ProductIdVO productId, PriorityVO priority, PriceVO price, CurrencyVO currency) {
}
