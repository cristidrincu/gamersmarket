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
public enum BeanValidationMessages {
    FAILED_CONSTRAINT_VALIDATION("The entity you are trying to persist does not pass bean validation.");
    
    private final String message;
    
    BeanValidationMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }        
}
