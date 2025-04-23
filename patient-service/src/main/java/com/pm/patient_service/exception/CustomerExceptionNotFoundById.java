package com.pm.patient_service.exception;

public class CustomerExceptionNotFoundById extends RuntimeException {
    public CustomerExceptionNotFoundById(String message) {
        super(message);
    }
}
