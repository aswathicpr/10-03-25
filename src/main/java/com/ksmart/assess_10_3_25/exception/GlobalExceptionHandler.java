package com.ksmart.assess_10_3_25.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> RuntimeException(RuntimeException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }

@ExceptionHandler(UserIdNotFoundException.class)
public ResponseEntity<String> UserIdNotFoundException(UserIdNotFoundException ex){
    return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
}

    }
  
    

