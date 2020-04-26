package com.osworks.osworksapi.domain.exception;

public class ServiceException extends RuntimeException {

    private static final long serialversionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }
}