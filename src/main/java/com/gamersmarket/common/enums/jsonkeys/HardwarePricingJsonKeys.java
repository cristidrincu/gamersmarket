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
public enum HardwarePricingJsonKeys {
    PRODUCT_AGE("age"),
    HAS_WARRANTY("hasWarranty"),
    MIN_PRICE("minPrice"),
    RECOMMENDED_PRICE("recommendedPrice"),
    SELL_PERIOD_HOURS("sellPeriodHours");
    
    private final String jsonKeyDescription;
    
    HardwarePricingJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }        
}
