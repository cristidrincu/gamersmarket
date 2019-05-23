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
public enum HardwareBidMessages {
    HARDWARE_BID_EQUAL_AMOUNT("The bid amount you are trying to place must be higher than the current highest bid amount."),
    HARDWARE_BID_LESS_AMOUNT("The bid amount you are trying to place is less than the current highest bid amount."),
    HARDWARE_BID_NOT_FOUND_FOR_OFFER("No hardware bid found for provided hardware offer"),
    HARDWARE_BID_NOT_FOUND_BY_ID("No hardware bid found matching provided id.");
    
    private final String message;
    
    HardwareBidMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }        
}
