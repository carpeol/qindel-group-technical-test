package com.qindel.test.prices.infrastructure.outbound.persistence;

import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import com.qindel.test.prices.domain.model.Price;
import com.qindel.test.prices.domain.vo.ApplicationDateVO;
import com.qindel.test.prices.domain.vo.BrandIdVO;
import com.qindel.test.prices.domain.vo.ProductIdVO;
import com.qindel.test.prices.infrastructure.outbound.persistence.mapper.PriceEntityMapper;
import com.qindel.test.prices.infrastructure.outbound.persistence.repository.PriceJpaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.QueryTimeoutException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceJpaRepositoryAdapterTest {
    @Mock
    private PriceJpaRepository priceJpaRepository;

    @Mock
    private PriceEntityMapper priceMapper;

    @InjectMocks
    private PriceJpaRepositoryAdapter adapter;

    @Test
    void shouldThrowPriceRepositoryError() {
        when(priceJpaRepository.findApplicablePrices(any(), any(), any()))
                .thenThrow(new QueryTimeoutException("DB Timeout"));

        assertThrows(PriceRepositoryError.class, () ->
                adapter.findApplicablePrice(
                        new BrandIdVO(1L),
                        new ProductIdVO(35455L),
                        new ApplicationDateVO(LocalDateTime.now())
                )
        );
    }

    @Test
    void shouldReturnEmptyResult() throws PriceRepositoryError {
        when(priceJpaRepository.findApplicablePrices(any(), any(), any())).thenReturn(List.of());
        Optional<Price> priceOptional = adapter.findApplicablePrice(
                new BrandIdVO(1L),
                new ProductIdVO(35455L),
                new ApplicationDateVO(LocalDateTime.now())
        );
        Assertions.assertThat(priceOptional).isEmpty();
    }
}