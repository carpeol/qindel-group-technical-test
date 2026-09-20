package com.qindel.test.prices.infrastructure.config;

import com.qindel.test.prices.application.find.FindApplicablePriceUC;
import com.qindel.test.prices.domain.repository.PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public FindApplicablePriceUC findApplicablePriceUC(PriceRepository priceRepository) {
        return new FindApplicablePriceUC(priceRepository);
    }
}
