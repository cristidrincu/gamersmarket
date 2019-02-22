package com.gamersmarket.utils.exceptions;

import com.gamersmarket.utils.errors.ErrorInfo;

import java.util.List;

public class InvalidJsonException extends RuntimeException {

    private static final long serialVersionUID = -5982271260001580151L;

    private final List<ErrorInfo> errors;

    public InvalidJsonException(List<ErrorInfo> errors) {
        super();
        this.errors = errors;
    }

    public InvalidJsonException(String message, List<ErrorInfo> errors) {
        super(message);
        this.errors = errors;
    }

    public List<ErrorInfo> getErrors() {
        return errors;
    }
}
