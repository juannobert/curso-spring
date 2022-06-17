package com.juannobert.animeapi.handler;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.juannobert.animeapi.exception.BadRequestException;
import com.juannobert.animeapi.exception.StandardError;
import com.juannobert.animeapi.exception.ValidationExceptionDetails;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> handlerBadRequestException(BadRequestException e,HttpServletRequest request){
		return new ResponseEntity<>(
				StandardError.builder()
				.instant(Instant.now())
				.mensage("Bad Request Exception")
				.status(HttpStatus.BAD_REQUEST.value())
				.error(e.getMessage())
				.path(request.getRequestURI())
		
				.build(),HttpStatus.BAD_REQUEST);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e,HttpServletRequest request){
		List<FieldError> fieldErros = e.getBindingResult().getFieldErrors();
		String fields = fieldErros.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldsMessage = fieldErros.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		return new ResponseEntity<>(
				ValidationExceptionDetails.builder()
				.instant(Instant.now())
				.mensage("Bad Request Exception,invalid Fields")
				.status(HttpStatus.BAD_REQUEST.value())
				.error(e.getMessage())
				.path(request.getRequestURI())
				.filds(fields)
				.fildsMessage(fieldsMessage)
				.build(),HttpStatus.BAD_REQUEST);
	}
	
	
}
