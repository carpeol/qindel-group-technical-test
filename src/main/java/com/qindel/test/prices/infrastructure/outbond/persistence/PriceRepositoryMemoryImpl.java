package com.qindel.test.prices.infrastructure.outbond.persistence;

import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import com.qindel.test.prices.domain.model.Price;
import com.qindel.test.prices.domain.repository.PriceRepository;
import com.qindel.test.prices.domain.vo.ApplicationDateVO;
import com.qindel.test.prices.domain.vo.BrandIdVO;
import com.qindel.test.prices.domain.vo.ProductIdVO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PriceRepositoryMemoryImpl implements PriceRepository {
    @Override
    public Optional<Price> findApplicablePrice(BrandIdVO brandId, ProductIdVO productId, ApplicationDateVO applicationDate) throws PriceRepositoryError {
        return Optional.empty();
    }
}
