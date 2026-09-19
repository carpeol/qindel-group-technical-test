package com.qindel.test.prices.domain.exception;

import com.qindel.test.prices.domain.vo.ApplicationDateVO;
import com.qindel.test.prices.domain.vo.BrandIdVO;
import com.qindel.test.prices.domain.vo.ProductIdVO;

public class ApplicablePriceNotFound extends Exception {
    public ApplicablePriceNotFound(BrandIdVO brandIdVO, ProductIdVO productIdVO, ApplicationDateVO applicationDateVO) {
        super("Applicable price for brandId " + brandIdVO.value() + " and productId " + productIdVO.value() + " not found for date " + applicationDateVO.toString());
    }
}
