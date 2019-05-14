/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.enums.hwofferstates;

/**
 *
 * @author cristiandrincu
 */
public enum HardwareOfferStates {
    PENDING("pending"),
    ACTIVE("active"),
    CANCELLED("cancelled");
    
    private final String hardwareOfferState;
    
    HardwareOfferStates(String hardwareOfferState) {
        this.hardwareOfferState = hardwareOfferState;
    }

    public String getHardwareOfferState() {
        return hardwareOfferState;
    }
}
