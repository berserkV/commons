package com.berserk.commons.exception;

import com.berserk.commons.model.ErrorResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@EnableWebMvc
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = BusinessException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ErrorResponse> handlerAoBusinessException(BusinessException abe) {
		ErrorResponse serviceStatus = ErrorResponse.builder().type(ErrorResponse.ErrorType.ERROR)
				.code(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value())).details(abe.getMessage()).build();
		log.error("type{},code={},message={}", serviceStatus.getType(), serviceStatus.getCode(),
				serviceStatus.getDetails(), abe);
		return new ResponseEntity<>(serviceStatus, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}