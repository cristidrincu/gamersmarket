/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.enums.messages;

/**
 *
 * @author cristiandrincu
 */
public enum AccountManagementMessages {
    NO_ACCOUNT_FOUND("No account found with provided credentials."),
    ACCOUNT_ALREADY_EXISTS("An account already exits with the given credentials."),
    ACCOUNT_CREATED_SUCCESSFULLY("Account created successfully."),
    ACCOUNT_DELETED_SUCCESSFULLY("Account deleted successfully."),
    ACCOUNT_FETCHED_SUCCESSFULLY("Account fetched successfully."),
    WRONG_CREDENTIALS("Wrong email or password.");
    
    private final String messageDescription;
    
    AccountManagementMessages(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public String getMessageDescription() {
        return messageDescription;
    }       
}
