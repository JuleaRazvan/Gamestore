package com.project.gamestore.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomApiErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
        APIError apiError = APIError.builder()
                .statusCode(HttpStatus.NOT_FOUND)
                .error(exception.getLocalizedMessage())
                .build();

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatusCode());
    }

}
