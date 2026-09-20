package com.qindel.test.prices.infrastructure.inbound.rest;

import com.qindel.test.prices.application.find.FindApplicablePriceUC;
import com.qindel.test.prices.domain.exception.ApplicablePriceNotFound;
import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    private final FindApplicablePriceUC findApplicablePriceUC;

    public PriceController(FindApplicablePriceUC findApplicablePriceUC) {
        this.findApplicablePriceUC = findApplicablePriceUC;
    }

    @GetMapping("/applicablePrice")
    @Operation(summary = "Find the applicable price for a product")
    public ResponseEntity<ApplicablePriceDTO> findApplicablePrice(
            @Parameter(description = "Brand identifier", example = "1")
            @RequestParam long brandId,
            @Parameter(description = "Product identifier", example = "35455")
            @RequestParam long productId,
            @Parameter(description = "Application date in format yyyy-MM-dd'T'HH:mm:ss.SSS",
                    example = PriceApiDateTime.EXAMPLE,
                    schema = @Schema(type = "string", pattern = PriceApiDateTime.REGEX,
                            example = PriceApiDateTime.EXAMPLE))
            @RequestParam @DateTimeFormat(pattern = PriceApiDateTime.PATTERN) LocalDateTime applicationDate)
            throws ApplicablePriceNotFound, PriceRepositoryError {
        return ResponseEntity.ok(ApplicablePriceDTO.from(findApplicablePriceUC.execute(productId, brandId, applicationDate)));
    }
}
