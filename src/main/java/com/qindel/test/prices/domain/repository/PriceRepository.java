package com.qindel.test.prices.domain.repository;

import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import com.qindel.test.prices.domain.model.Price;
import com.qindel.test.prices.domain.vo.ApplicationDateVO;
import com.qindel.test.prices.domain.vo.BrandIdVO;
import com.qindel.test.prices.domain.vo.ProductIdVO;

import java.util.Optional;

public interface PriceRepository {
    Optional<Price> findApplicablePrice(BrandIdVO brandId, ProductIdVO productId, ApplicationDateVO applicationDate)
            throws PriceRepositoryError;
}
