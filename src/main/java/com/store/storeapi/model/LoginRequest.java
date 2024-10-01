package com.store.storeapi.model;

import com.store.storeapi.exception.UserCredentialException;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;


public record LoginRequest(String username, @NotBlank String password, String email) {
    public LoginRequest {
        if (username == null && email == null) {
            throw new UserCredentialException("Neither email nor user has been entered" , HttpStatus.BAD_REQUEST);
        }
    }
}
