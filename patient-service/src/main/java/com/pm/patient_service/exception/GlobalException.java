package com.pm.patient_service.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {


    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);


    @ExceptionHandler(CustomerExceptionNotFoundById.class)
    public ResponseEntity<ResponseError> handlePatientNotFoundException(CustomerExceptionNotFoundById exp){

        log.warn("Patient not found by provided id {}", exp.getMessage());
        var errors = new HashMap<String, String>();

        errors.put("message", "Patient not found by provided id");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(errors));
    }


    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ResponseError> handleEmailAlreadyExistsException(EmailAlreadyExistsException exp){


        // to see error in the console for ourselves
        log.warn("Email address already exists {}", exp.getMessage());
        var errors = new HashMap<String, String>();

        errors.put("message", "Email address already exists");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(errors));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidationException(MethodArgumentNotValidException exp){

        var errors = new HashMap<String, String>();

        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError)error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(errors));
    }

}
