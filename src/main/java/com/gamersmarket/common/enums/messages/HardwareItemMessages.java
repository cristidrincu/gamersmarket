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
public enum HardwareItemMessages {
    HARDWARE_ITEM_RETRIEVED_SUCCESSFULLY("Hardware item retrieved successfully."),
    HARDWARE_ITEM_CREATED_SUCCESSFULLY("Hardware item created successfully.");
    
    private final String message;
    
    HardwareItemMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }        
}
