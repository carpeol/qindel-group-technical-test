package com.qindel.test.prices.infrastructure.inbound.rest;

import com.qindel.test.prices.domain.exception.ApplicablePriceNotFound;
import com.qindel.test.prices.domain.exception.InvalidField;
import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(InvalidField.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidField(InvalidField exception) {
        log.error(exception.getMessage());
        return Map.of("errorCode", "INVALID_FIELD", "errorMessage", exception.getMessage());
    }

    @ExceptionHandler(ApplicablePriceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleApplicablePriceNotFound(ApplicablePriceNotFound exception) {
        log.error(exception.getMessage());
        return Map.of("errorCode", "APPLICABLE_PRICE_NOT_FOUND", "errorMessage", exception.getMessage());
    }

    @ExceptionHandler(PriceRepositoryError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handlePriceRepositoryError(PriceRepositoryError exception) {
        log.error(exception.getMessage());
        return Map.of("errorCode", "PRICE_REPOSITORY_ERROR", "errorMessage", exception.getMessage());
    }


}
