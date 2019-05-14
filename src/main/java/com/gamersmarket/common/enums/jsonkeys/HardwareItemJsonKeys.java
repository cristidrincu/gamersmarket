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
public enum HardwareItemJsonKeys {
    MANUFACTURER_CODE("manufacturerCode"),
    HW_ITEM_NAME("name"), 
    MANUFACTURER("manufacturer");
    
    private final String jsonKeyDescription;
    
    private HardwareItemJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }   
}
