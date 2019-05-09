package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.enums.jsonkeys.KeyboardJsonKeys;
import com.gamersmarket.common.deserializers.KeyboardDeserializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "hw_item_keyboard")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Keyboard")
@JsonDeserialize(using = KeyboardDeserializer.class)
@NamedQueries({
        @NamedQuery(name = Keyboard.FIND_ALL_KEYBOARDS, query = Keyboard.FIND_ALL_KEYBOARDS_QUERY),
        @NamedQuery(name = Keyboard.FIND_KEYBOARD_BY_ID, query = Keyboard.FIND_KEYBOARD_BY_ID_QUERY)
})
@XmlRootElement
public class Keyboard extends HardwareItem implements Serializable {

    private static final long serialVersionUID = 8674635200938651078L;

    public static final String KEYBOARD_PARAM_ID = "id";

    public static final String FIND_ALL_KEYBOARDS = "find_all_keyboards";
    public static final String FIND_KEYBOARD_BY_ID = "find_keyboard_by_id";

    public static final String FIND_ALL_KEYBOARDS_QUERY = "select keyboard from Keyboard keyboard";
    public static final String FIND_KEYBOARD_BY_ID_QUERY = "select keyboard from Keyboard keyboard where keyboard.id = :" + KEYBOARD_PARAM_ID;

    @Id
    @NotNull    
    private int id;

    @Column(name = "keyboard_type")
    private String keyboardType;

    @Column(name = "keyboard_colour")
    private String keyboardColour;

    @Column(name = "has_numerical_keys")
    private int hasNumericalKeys;

    @Column(name = "nr_of_keys")
    private int nrOfKeys;

    @Column(name = "keyboard_technology")
    private String keyboardTechnology;

    @Column(name = "keyboard_interface")
    private String keyboardInterface;

    @Column(name = "keyboard_wire_length")
    private String keyboardWireLength;

    @Column(name = "is_mechanical")
    private int isMechanical;

    @Column(name = "has_palm_rest")
    private int hasPalmRest;

    @Column(name = "keyboard_keys_layout")
    private String keyboardKeysLayout;

    @Column(name = "has_illumination")
    private int hasIllumination;

    @Column(name = "led_colour")
    private String ledColour;    

    public Keyboard() {}

    public Keyboard(Keyboard keyboard, String name, String manufacturerCode) {
        super(name, manufacturerCode);
        this.id = keyboard.getId();
        this.keyboardType = keyboard.getKeyboardType();
        this.keyboardColour = keyboard.getKeyboardColour();
        this.hasNumericalKeys = keyboard.getHasNumericalKeys();
        this.nrOfKeys = keyboard.getNrOfKeys();
        this.keyboardTechnology = keyboard.getKeyboardTechnology();
        this.keyboardInterface = keyboard.getKeyboardInterface();
        this.keyboardWireLength = keyboard.getKeyboardWireLength();
        this.isMechanical = keyboard.getIsMechanical();
        this.hasPalmRest = keyboard.getHasPalmRest();
        this.keyboardKeysLayout = keyboard.getKeyboardKeysLayout();
        this.hasIllumination = keyboard.getHasIllumination();
        this.ledColour = keyboard.getLedColour();
        this.createdOn = keyboard.getCreatedOn();
        this.updatedOn = keyboard.getUpdatedOn();        
    }

    public Keyboard(JsonNode keyboardNode) {
        super(keyboardNode.get("manufacturerCode").asText(), keyboardNode.get("name").asText());
        this.keyboardType = keyboardNode.get(KeyboardJsonKeys.KEYBOARD_TYPE.getJsonKeyDescription()).asText();
        this.keyboardColour = keyboardNode.get(KeyboardJsonKeys.KEYBOARD_COLOUR.getJsonKeyDescription()).asText();
        this.hasNumericalKeys = keyboardNode.get(KeyboardJsonKeys.HAS_NUMERICAL_KEYS.getJsonKeyDescription()).asInt();
        this.nrOfKeys = keyboardNode.get(KeyboardJsonKeys.NR_OF_KEYS.getJsonKeyDescription()).asInt();
        this.keyboardTechnology = keyboardNode.get(KeyboardJsonKeys.KEYBOARD_TECHNOLOGY.getJsonKeyDescription()).asText();
        this.keyboardInterface = keyboardNode.get(KeyboardJsonKeys.KEYBOARD_INTERFACE.getJsonKeyDescription()).asText();
        this.keyboardWireLength = keyboardNode.get(KeyboardJsonKeys.KEYBOARD_WIRE_LENGTH.getJsonKeyDescription()).asText();
        this.isMechanical = keyboardNode.get(KeyboardJsonKeys.IS_MECHANICAL.getJsonKeyDescription()).asInt();
        this.hasPalmRest = keyboardNode.get(KeyboardJsonKeys.HAS_PALM_REST.getJsonKeyDescription()).asInt();
        this.keyboardKeysLayout = keyboardNode.get(KeyboardJsonKeys.KEYBOARD_KEYS_LAYOUT.getJsonKeyDescription()).asText();
        this.hasIllumination = keyboardNode.get(KeyboardJsonKeys.HAS_ILLUMINATION.getJsonKeyDescription()).asInt();
        this.ledColour = keyboardNode.get(KeyboardJsonKeys.LED_COLOUR.getJsonKeyDescription()).asText();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    public String getKeyboardColour() {
        return keyboardColour;
    }

    public void setKeyboardColour(String keyboardColour) {
        this.keyboardColour = keyboardColour;
    }

    public int getHasNumericalKeys() {
        return hasNumericalKeys;
    }

    public void setHasNumericalKeys(short hasNumericalKeys) {
        this.hasNumericalKeys = hasNumericalKeys;
    }

    public int getNrOfKeys() {
        return nrOfKeys;
    }

    public void setNrOfKeys(short nrOfKeys) {
        this.nrOfKeys = nrOfKeys;
    }

    public String getKeyboardTechnology() {
        return keyboardTechnology;
    }

    public void setKeyboardTechnology(String keyboardTechnology) {
        this.keyboardTechnology = keyboardTechnology;
    }

    public String getKeyboardInterface() {
        return keyboardInterface;
    }

    public void setKeyboardInterface(String keyboardInterface) {
        this.keyboardInterface = keyboardInterface;
    }

    public String getKeyboardWireLength() {
        return keyboardWireLength;
    }

    public void setKeyboardWireLength(String keyboardWireLength) {
        this.keyboardWireLength = keyboardWireLength;
    }

    public int getIsMechanical() {
        return isMechanical;
    }

    public void setIsMechanical(short isMechanical) {
        this.isMechanical = isMechanical;
    }

    public int getHasPalmRest() {
        return hasPalmRest;
    }

    public void setHasPalmRest(short hasPalmRest) {
        this.hasPalmRest = hasPalmRest;
    }

    public String getKeyboardKeysLayout() {
        return keyboardKeysLayout;
    }

    public void setKeyboardKeysLayout(String keyboardKeysLayout) {
        this.keyboardKeysLayout = keyboardKeysLayout;
    }

    public int getHasIllumination() {
        return hasIllumination;
    }

    public void setHasIllumination(short hasIllumination) {
        this.hasIllumination = hasIllumination;
    }

    public String getLedColour() {
        return ledColour;
    }

    public void setLedColour(String ledColour) {
        this.ledColour = ledColour;
    }      

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyboard keyboard = (Keyboard) o;
        return id == keyboard.id &&
                createdOn.equals(keyboard.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "id=" + id +
                ", keyboardType='" + keyboardType + '\'' +
                ", keyboardColour='" + keyboardColour + '\'' +
                ", hasNumericalKeys=" + hasNumericalKeys +
                ", nrOfKeys=" + nrOfKeys +
                ", keyboardTechnology='" + keyboardTechnology + '\'' +
                ", keyboardInterface='" + keyboardInterface + '\'' +
                ", keyboardWireLength='" + keyboardWireLength + '\'' +
                ", isMechanical=" + isMechanical +
                ", hasPalmRest=" + hasPalmRest +
                ", keyboardKeysLayout='" + keyboardKeysLayout + '\'' +
                ", hasIllumination=" + hasIllumination +
                ", ledColour='" + ledColour + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +                
                '}';
    }
}
