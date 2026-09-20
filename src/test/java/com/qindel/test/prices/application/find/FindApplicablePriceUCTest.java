package com.qindel.test.prices.application.find;

import com.qindel.test.prices.domain.exception.ApplicablePriceNotFound;
import com.qindel.test.prices.domain.exception.InvalidField;
import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import com.qindel.test.prices.domain.repository.PriceRepository;
import com.qindel.test.prices.domain.vo.ApplicationDateVO;
import com.qindel.test.prices.domain.vo.BrandIdVO;
import com.qindel.test.prices.domain.vo.ProductIdVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindApplicablePriceUCTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private FindApplicablePriceUC findApplicablePriceUC;

    @Test
    void shouldThrowApplicablePriceNotFound() throws PriceRepositoryError {
        when(priceRepository.findApplicablePrice(any(), any(), any())).thenReturn(Optional.empty());
        LocalDateTime now = LocalDateTime.now();
        assertThrows(ApplicablePriceNotFound.class, () -> findApplicablePriceUC.execute(1L, 1L, now));
        verify(priceRepository).findApplicablePrice(new BrandIdVO(1L), new ProductIdVO(1L), new ApplicationDateVO(now));
    }

    @Test
    void shouldThrowInvalidField() throws PriceRepositoryError {
        InvalidField invalidField = assertThrows(InvalidField.class, () -> findApplicablePriceUC.execute(-1L, 1L, LocalDateTime.now()));
        assertThat(invalidField.getMessage()).contains("productId");
        verifyNoInteractions(priceRepository);
    }


}