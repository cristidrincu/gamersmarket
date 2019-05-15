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
public enum HardwareOfferMessages {
    FETCH_ALL_HARDWARE_OFFERS("Hardware offers fetched successfully."),
    INITIAL_HARDWARE_OFFER_SUCCESS_MESSAGE("Initial hardware offer created successfully."),
    FINAL_HARDWARE_OFFER_SUCCESS_MESSAGE("Final hardware offer created successfully.");
    
    private final String messageDescription;
    
    HardwareOfferMessages(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public String getMessageDescription() {
        return messageDescription;
    }    
}
