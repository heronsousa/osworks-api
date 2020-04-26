package com.osworks.osworksapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.osworks.osworksapi.api.exceptionhandler.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        ArrayList<Error.Input> inputs = new ArrayList<Error.Input>();
        
        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            inputs.add(new Error.Input(name, message));
        }

        Error error = new Error();
        error.setStatus(status.value());
        error.setTitle("Um ou mais campos estão inválidos. Tente novamente.");
        error.setDateTime(LocalDateTime.now());
        error.setInputs(inputs);

        return super.handleExceptionInternal(ex, error, headers, status, request);
    }
}