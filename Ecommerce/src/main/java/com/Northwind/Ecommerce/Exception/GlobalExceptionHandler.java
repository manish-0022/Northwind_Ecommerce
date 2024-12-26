package com.Northwind.Ecommerce.Exception;

import com.Northwind.Ecommerce.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Response> handleAllException(Exception ex, WebRequest request){
        Response errorResponse = Response.builder().
                status(HttpStatus.INTERNAL_SERVER_ERROR.value()).
                message(ex.getMessage()).build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handleNotFoundException(Exception ex, WebRequest request) {
        Response errorResponse = Response.builder().
                status(HttpStatus.NOT_FOUND.value()).
                message(ex.getMessage()).build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<Response> handleInvalidCredentialException(Exception ex, WebRequest request) {
        Response errorResponse = Response.builder().
                status(HttpStatus.BAD_REQUEST.value()).
                message(ex.getMessage()).build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }








}
