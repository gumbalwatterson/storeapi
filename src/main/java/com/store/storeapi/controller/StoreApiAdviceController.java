package com.store.storeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.storeapi.exception.UserCredentialException;
import com.store.storeapi.model.StoreApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class StoreApiAdviceController {
    private final ObjectMapper mapper;

    @ExceptionHandler(UserCredentialException.class)
    public ResponseEntity<StoreApiError> handleClientError(UserCredentialException ex) {
        StoreApiError storeApiError = new StoreApiError(ex.getHttpStatusCode().value(), ex.getMessage());
        return new ResponseEntity<>(storeApiError, HttpStatus.valueOf(ex.getHttpStatusCode().value()));
    }

}
