package com.tqi_evolution_backend_2021.analisecred.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
