package com.example.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PaymentException extends Exception {

    public PaymentException(String message) {
        super(message);
    }
}
