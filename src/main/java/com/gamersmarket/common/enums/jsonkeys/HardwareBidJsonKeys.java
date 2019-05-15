/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.enums.jsonkeys;

/**
 *
 * @author cristiandrincu
 */
public enum HardwareBidJsonKeys {
    AMOUNT("amount"),
    BID_STATE("bidState"),
    BIDDER_ID("bidderId"),
    HARDWARE_OFFER_ID("hardwareOfferId");

    private final String jsonKeyDescription;
    
    HardwareBidJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }    
}
