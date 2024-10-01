package com.store.storeapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class UserCredentialException extends RuntimeException {
    private String message;
    private HttpStatusCode httpStatusCode;

    public UserCredentialException(String msg, HttpStatusCode httpStatusCode) {
        super(msg);
        this.message = msg;
        this.httpStatusCode = httpStatusCode;

    }
}
