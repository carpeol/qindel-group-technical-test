package com.qindel.test.prices.infrastructure.outbound.persistence.mapper;

import com.qindel.test.prices.domain.model.Price;
import com.qindel.test.prices.domain.vo.*;
import com.qindel.test.prices.infrastructure.outbound.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceEntityMapper {

    public Price toDomain(PriceEntity entity) {
        return new Price(
                new BrandIdVO(entity.getBrandId()),
                new StartDateVO(entity.getStartDate()),
                new EndDateVO(entity.getEndDate()),
                new PriceIdVO(entity.getPriceList()),
                new ProductIdVO(entity.getProductId()),
                new PriorityVO(entity.getPriority()),
                new PriceVO(entity.getPrice()),
                new CurrencyVO(entity.getCurrency())
        );
    }
}
