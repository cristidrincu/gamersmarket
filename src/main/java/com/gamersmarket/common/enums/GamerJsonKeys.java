/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.enums;

/**
 *
 * @author cristiandrincu
 */
public enum GamerJsonKeys {
    ROOT_NODE("gamer"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    EMAIL_ADDRESS("email"),
    GAMER_AGE("age"),
    PASSWORD("password");
    
    private final String jsonKeyDescription;
    
    GamerJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }        
}
