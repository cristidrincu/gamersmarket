package com.gamersmarket.constants;

public class KeyboardJsonKeys {

    private KeyboardJsonKeys() {}

    private static final String KEYBOARD_TYPE = "keyboardType";
    private static final String KEYBOARD_COLOUR = "keyboardColour";
    private static final String HAS_NUMERICAL_KEYS = "hasNumericalKeys";
    private static final String NR_OF_KEYS = "nrOfKeys";
    private static final String KEYBOARD_TECHNOLOGY = "keyboardTechnology";
    private static final String KEYBOARD_INTERFACE = "keyboardInterface";
    private static final String KEYBOARD_WIRE_LENGTH = "keyboardWireLength";
    private static final String IS_MECHANICAL = "isMechanical";
    private static final String HAS_PALM_REST = "hasPalmRest";
    private static final String KEYBOARD_KEYS_LAYOUT = "keyboardKeysLayout";
    private static final String HAS_ILLUMINATION = "hasIllumination";
    private static final String LED_COLOUR = "ledColour";

    public static String getKeyboardType() {
        return KEYBOARD_TYPE;
    }

    public static String getKeyboardColour() {
        return KEYBOARD_COLOUR;
    }

    public static String getHasNumericalKeys() {
        return HAS_NUMERICAL_KEYS;
    }

    public static String getNrOfKeys() {
        return NR_OF_KEYS;
    }

    public static String getKeyboardTechnology() {
        return KEYBOARD_TECHNOLOGY;
    }

    public static String getKeyboardInterface() {
        return KEYBOARD_INTERFACE;
    }

    public static String getKeyboardWireLength() {
        return KEYBOARD_WIRE_LENGTH;
    }

    public static String getIsMechanical() {
        return IS_MECHANICAL;
    }

    public static String getHasPalmRest() {
        return HAS_PALM_REST;
    }

    public static String getKeyboardKeysLayout() {
        return KEYBOARD_KEYS_LAYOUT;
    }

    public static String getHasIllumination() {
        return HAS_ILLUMINATION;
    }

    public static String getLedColour() {
        return LED_COLOUR;
    }
}
