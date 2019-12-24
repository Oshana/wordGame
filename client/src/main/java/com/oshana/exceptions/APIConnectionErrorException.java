package com.oshana.exceptions;

public class APIConnectionErrorException extends RuntimeException {
    public APIConnectionErrorException(Exception e) {
        super(e);
    }
}
