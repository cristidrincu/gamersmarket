package com.gamersmarket.common.constants;

public class MouseJsonKeys {

    private MouseJsonKeys() {}

    private static final String CONNECTION_TYPE = "connectionType";
    private static final String SENSOR_TECHNOLOGY = "sensorTechnology";
    private static final String BUTTONS = "buttons";
    private static final String SCROLLING_BUTTONS = "scrollingButtons";
    private static final String COLOUR = "colour";
    private static final String HAS_ILLUMINATION = "hasIllumination";
    private static final String LED_COLOR = "ledColor";
    private static final String CABLE_LENGTH = "cableLength";
    private static final String WEIGHT = "weight";
    private static final String DPI = "dpi";
    private static final String IS_WIRELESS = "isWireless";

    public static String getConnectionType() {
        return CONNECTION_TYPE;
    }

    public static String getSensorTechnology() {
        return SENSOR_TECHNOLOGY;
    }

    public static String getButtons() {
        return BUTTONS;
    }

    public static String getScrollingButtons() {
        return SCROLLING_BUTTONS;
    }

    public static String getColour() {
        return COLOUR;
    }

    public static String getHasIllumination() {
        return HAS_ILLUMINATION;
    }

    public static String getLedColor() {
        return LED_COLOR;
    }

    public static String getCableLength() {
        return CABLE_LENGTH;
    }

    public static String getWeight() {
        return WEIGHT;
    }

    public static String getDpi() {
        return DPI;
    }

    public static String getIsWireless() {
        return IS_WIRELESS;
    }
}
