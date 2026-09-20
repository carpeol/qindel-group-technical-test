package com.qindel.test.prices.application.find;

import com.qindel.test.prices.domain.exception.ApplicablePriceNotFound;
import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import com.qindel.test.prices.domain.model.Price;
import com.qindel.test.prices.domain.repository.PriceRepository;
import com.qindel.test.prices.domain.vo.ApplicationDateVO;
import com.qindel.test.prices.domain.vo.BrandIdVO;
import com.qindel.test.prices.domain.vo.ProductIdVO;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class FindApplicablePriceUC {

    private final PriceRepository priceRepository;

    public FindApplicablePriceUC(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public ApplicablePriceResponse execute(Long productId, Long brandId, LocalDateTime applicationDate) throws PriceRepositoryError, ApplicablePriceNotFound {
        ProductIdVO productIdVO = new ProductIdVO(productId);
        BrandIdVO brandIdVO = new BrandIdVO(brandId);
        ApplicationDateVO applicationDateVO = new ApplicationDateVO(applicationDate);
        log.debug("Finding applicable price for productId {}, brandId {} and date {}", productIdVO.value(), brandIdVO.value(), applicationDateVO);

        return priceRepository.findApplicablePrice(brandIdVO, productIdVO, applicationDateVO)
                .map(this::toApplicablePrice)
                .orElseThrow(() -> new ApplicablePriceNotFound(brandIdVO, productIdVO, applicationDateVO));
    }

    private ApplicablePriceResponse toApplicablePrice(Price price) {
        return new ApplicablePriceResponse(
                price.productId().value(),
                price.brandId().value(),
                price.priceId().value(),
                price.startDate().value(),
                price.endDate().value(),
                price.price().value(),
                price.currency().value()
        );
    }
}
