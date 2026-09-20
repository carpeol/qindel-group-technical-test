package com.qindel.test.prices.infrastructure.outbound.persistence;

import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import com.qindel.test.prices.domain.model.Price;
import com.qindel.test.prices.domain.repository.PriceRepository;
import com.qindel.test.prices.domain.vo.ApplicationDateVO;
import com.qindel.test.prices.domain.vo.BrandIdVO;
import com.qindel.test.prices.domain.vo.ProductIdVO;
import com.qindel.test.prices.infrastructure.outbound.persistence.mapper.PriceEntityMapper;
import com.qindel.test.prices.infrastructure.outbound.persistence.repository.PriceJpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PriceJpaRepositoryAdapter implements PriceRepository {

    private final PriceJpaRepository priceRepository;
    private final PriceEntityMapper priceEntityMapper;

    public PriceJpaRepositoryAdapter(PriceJpaRepository priceRepository, PriceEntityMapper priceEntityMapper) {
        this.priceRepository = priceRepository;
        this.priceEntityMapper = priceEntityMapper;
    }

    @Override
    public Optional<Price> findApplicablePrice(
            BrandIdVO brandId,
            ProductIdVO productId,
            ApplicationDateVO applicationDate
    ) throws PriceRepositoryError {
        try {
            return priceRepository.findApplicablePrices(
                            brandId.value(), productId.value(), applicationDate.value())
                    .stream()
                    .findFirst()
                    .map(priceEntityMapper::toDomain);
        } catch (DataAccessException exception) {
            throw new PriceRepositoryError("Unable to find the applicable price", exception);
        }
    }
}
