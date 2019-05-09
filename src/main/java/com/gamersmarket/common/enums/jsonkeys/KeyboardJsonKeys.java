package com.gamersmarket.common.enums.jsonkeys;

public enum KeyboardJsonKeys {   
    ROOT_NODE("keyboard"),
    KEYBOARD_TYPE("keyboardType"),
    KEYBOARD_COLOUR("keyboardColour"),
    HAS_NUMERICAL_KEYS("hasNumericalKeys"),
    NR_OF_KEYS("nrOfKeys"),
    KEYBOARD_TECHNOLOGY("keyboardTechnology"),
    KEYBOARD_INTERFACE("keyboardInterface"),
    KEYBOARD_WIRE_LENGTH("keyboardWireLength"),
    IS_MECHANICAL("isMechanical"),
    HAS_PALM_REST("hasPalmRest"),
    KEYBOARD_KEYS_LAYOUT("keyboardKeysLayout"),
    HAS_ILLUMINATION("hasIllumination"),
    LED_COLOUR("ledColour");

    private final String jsonKeyDescription;

    private KeyboardJsonKeys(String jsonKeyDescription) {
        this.jsonKeyDescription = jsonKeyDescription;
    }

    public String getJsonKeyDescription() {
        return jsonKeyDescription;
    }    
}
