package br.com.foursys.fourcamp.store.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.foursys.fourcamp.store.service.exceptions.ControllerNotFoundException;

@ControllerAdvice
public class ResourceException {

	@ExceptionHandler(ControllerNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ControllerNotFoundException e, HttpServletRequest request) {
		String error = "Controller not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
