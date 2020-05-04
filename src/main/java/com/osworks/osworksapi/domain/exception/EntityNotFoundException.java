package com.osworks.osworksapi.domain.exception;

public class EntityNotFoundException extends ServiceException {
    
    private static final long serialversionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}