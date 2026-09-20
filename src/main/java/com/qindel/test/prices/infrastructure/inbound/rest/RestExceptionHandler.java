package com.qindel.test.prices.infrastructure.inbound.rest;

import com.qindel.test.prices.domain.exception.ApplicablePriceNotFound;
import com.qindel.test.prices.domain.exception.InvalidField;
import com.qindel.test.prices.domain.exception.PriceRepositoryError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(InvalidField.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleInvalidField(InvalidField exception) {
        log.error(exception.getMessage());
        return new ErrorResponseDTO("INVALID_FIELD", exception.getMessage());
    }

    @ExceptionHandler(ApplicablePriceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleApplicablePriceNotFound(ApplicablePriceNotFound exception) {
        log.error(exception.getMessage());
        return new ErrorResponseDTO("APPLICABLE_PRICE_NOT_FOUND", exception.getMessage());
    }

    @ExceptionHandler(PriceRepositoryError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handlePriceRepositoryError(PriceRepositoryError exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorResponseDTO("PRICE_REPOSITORY_ERROR", exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleInvalidRequestParameter(MethodArgumentTypeMismatchException exception) {
        String message = "Parameter " + exception.getName() + " has an invalid value";
        return new ErrorResponseDTO("INVALID_REQUEST_PARAMETER", message);
    }

}
