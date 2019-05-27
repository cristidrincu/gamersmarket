package com.gamersmarket.common.enums.jsonkeys;

import java.util.EnumSet;
import java.util.HashSet;

public enum MouseJsonKeys {   
    ROOT_NODE("mouse"),
    MANUFACTURER("manufacturer"),
    MANUFACTURER_CODE("manufacturerCode"),
    NAME("name"),
    CONNECTION_TYPE("connectionType"),
    SENSOR_TECHNOLOGY("sensorTechnology"),
    BUTTONS("buttons"),
    SCROLLING_BUTTONS("scrollingButtons"),
    COLOUR("colour"),
    HAS_ILLUMINATION("hasIllumination"),
    LED_COLOR("ledColor"),
    CABLE_LENGTH("cableLength"),
    WEIGHT("weight"),
    DPI("dpi"),
    IS_WIRELESS("isWireless");

    private final String jsonKeyDescription;

    MouseJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }
    
    public static HashSet<String> getMouseKeyConstantsAsSet() {
        HashSet<String> keys = new HashSet<>();
        EnumSet.allOf(MouseJsonKeys.class).forEach(key -> keys.add(key.getJsonKeyDescription()));        
        return keys;
    }        
}
