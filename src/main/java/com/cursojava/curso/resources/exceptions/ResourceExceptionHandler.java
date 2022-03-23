package com.cursojava.curso.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursojava.curso.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // Essa classe vai fazer o tratamento das exceções
public class ResourceExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class) // Recebe a exceção a ser tratada
	public ResponseEntity<StandardError> notFound(ResourceNotFoundException e,HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
}
