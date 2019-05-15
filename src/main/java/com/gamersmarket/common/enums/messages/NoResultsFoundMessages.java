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
public enum NoResultsFoundMessages {
    HARDWARE_OFFER_NOT_FOUND_BY_ID("No hardware offer found with provided id."),
    USER_ACCOUNT_NOT_FOUND("No user account found. Please check email address or password and try again.");
    
    private final String errorMessage;
    
    NoResultsFoundMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }        
}
