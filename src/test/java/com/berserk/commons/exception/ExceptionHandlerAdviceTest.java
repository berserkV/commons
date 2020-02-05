package com.berserk.commons.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.berserk.commons.model.ErrorResponse;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class ExceptionHandlerAdviceTest {

    private ExceptionHandlerAdvice exceptionHandlerAdvice;

    @Test
    public void handlerBusinessException() {
        exceptionHandlerAdvice = new ExceptionHandlerAdvice();
        ResponseEntity<ErrorResponse> citiServiceException = exceptionHandlerAdvice
                .handlerAoBusinessException(new BusinessException("BusinessException"));

        ErrorResponse errorResponse = citiServiceException.getBody();

        assertEquals("422", errorResponse.getCode());
    }
}