package com.qindel.test.prices.infrastructure.outbound.persistence.repository;

import com.qindel.test.prices.infrastructure.outbound.persistence.entity.PriceEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@Sql(scripts = "/sql/prices-test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class PriceJpaRepositoryIT {

    @Autowired
    private PriceJpaRepository priceJpaRepository;

    private static final Long BRAND_ID = 1L;
    private static final Long PRODUCT_ID = 1L;

    @Test
    void shouldReturnOnePrice() {
        LocalDateTime queryDate = LocalDateTime.of(2026, 1, 1, 10, 0, 0);

        List<PriceEntity> result = priceJpaRepository.findApplicablePrices(BRAND_ID, PRODUCT_ID, queryDate);

        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.getFirst().getPriceList()).isEqualTo(5L);
    }

    @Test
    void shouldReturnTwoPrice() {
        LocalDateTime queryDate = LocalDateTime.of(2026, 6, 14, 17, 0, 0);

        List<PriceEntity> result = priceJpaRepository.findApplicablePrices(BRAND_ID, PRODUCT_ID, queryDate);

        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result.getFirst().getPriceList()).isEqualTo(6L);
    }

}