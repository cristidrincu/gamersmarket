/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.enums.language;

/**
 *
 * @author cristiandrincu
 */
public enum Languages {
    DEFAULT_LANGUAGE("en");
    
    private final String language;
    
    Languages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }        
}
