package com.qindel.test.prices.infrastructure.outbound.persistence.repository;

import com.qindel.test.prices.infrastructure.outbound.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
            select price from PriceEntity price
            where price.brandId = :brandId
              and price.productId = :productId
              and :applicationDate between price.startDate and price.endDate
            order by price.priority desc
            """)
    List<PriceEntity> findApplicablePrices(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("applicationDate") LocalDateTime applicationDate
    );
}
