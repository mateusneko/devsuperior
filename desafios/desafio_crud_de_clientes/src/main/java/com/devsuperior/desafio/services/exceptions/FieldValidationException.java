package com.devsuperior.desafio.services.exceptions;

public class FieldValidationException extends RuntimeException {
    public FieldValidationException(String message) {
        super(message);
    }
}
