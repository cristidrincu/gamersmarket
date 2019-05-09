package com.gamersmarket.common.enums;

public enum MouseJsonKeys {   
    ROOT_NODE("mouse"),
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

    private MouseJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }        
}
