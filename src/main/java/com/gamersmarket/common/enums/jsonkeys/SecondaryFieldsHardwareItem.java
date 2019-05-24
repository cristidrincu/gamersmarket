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
public enum SecondaryFieldsHardwareItem {
    HW_TYPE_ROOT_NODE("hwType"),
    HW_TYPE_ID("id"),
    GAMER_ROOT_NODE("gamer"),
    GAMER_ID("id");
    
    private final String jsonKeyDescription;
    
    SecondaryFieldsHardwareItem(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }        
}
