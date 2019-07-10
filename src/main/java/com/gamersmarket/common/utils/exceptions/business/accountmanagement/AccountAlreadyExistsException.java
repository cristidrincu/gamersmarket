package com.gamersmarket.common.utils.exceptions.business.accountmanagement;

public class AccountAlreadyExistsException extends AccountManagementException {

    private static final long serialVersionUID = -8784986293072127385L;

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
