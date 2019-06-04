package com.gamersmarket.common.utils.exceptions.persistence;

public class AccountAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = -8784986293072127385L;

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
