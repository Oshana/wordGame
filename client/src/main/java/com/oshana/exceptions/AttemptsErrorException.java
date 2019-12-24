package com.oshana.exceptions;

public class AttemptsErrorException extends RuntimeException {
    public AttemptsErrorException(Exception e) {
        super(e);
    }
}
