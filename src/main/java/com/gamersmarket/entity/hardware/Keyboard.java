package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.constants.KeyboardJsonKeys;
import com.gamersmarket.common.deserializers.KeyboardDeserializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hw_item_keyboard")
@JsonDeserialize(using = KeyboardDeserializer.class)
@NamedQueries({
        @NamedQuery(name = Keyboard.FIND_ALL_KEYBOARDS, query = Keyboard.FIND_ALL_KEYBOARDS_QUERY),
        @NamedQuery(name = Keyboard.FIND_KEYBOARD_BY_ID, query = Keyboard.FIND_KEYBOARD_BY_ID_QUERY)
})
public class Keyboard implements Serializable {

    private static final long serialVersionUID = 8674635200938651078L;

    private static final String PARAM_ID = "id";

    public static final String FIND_ALL_KEYBOARDS = "find_all_keyboards";
    public static final String FIND_KEYBOARD_BY_ID = "find_keyboard_by_id";

    public static final String FIND_ALL_KEYBOARDS_QUERY = "select keyboard from Keyboard keyboard";
    public static final String FIND_KEYBOARD_BY_ID_QUERY = "select keyboard from Keyboard keyboard where keyboard.id = :" + PARAM_ID;

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_item")
    @SequenceGenerator(name = "sq_hardware_item_keyboard", sequenceName = "sq_hardware_item")
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardware_item_id")
    private HardwareItem hardwareItem;

    public Keyboard() {}

    public Keyboard(Keyboard keyboard) {
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
        this.hardwareItem = keyboard.getHardwareItem();
    }

    public Keyboard(JsonNode keyboardNode) {
        this.keyboardType = keyboardNode.get(KeyboardJsonKeys.getKeyboardType()).asText();
        this.keyboardColour = keyboardNode.get(KeyboardJsonKeys.getKeyboardColour()).asText();
        this.hasNumericalKeys = keyboardNode.get(KeyboardJsonKeys.getHasNumericalKeys()).asInt();
        this.nrOfKeys = keyboardNode.get(KeyboardJsonKeys.getNrOfKeys()).asInt();
        this.keyboardTechnology = keyboardNode.get(KeyboardJsonKeys.getKeyboardTechnology()).asText();
        this.keyboardInterface = keyboardNode.get(KeyboardJsonKeys.getKeyboardInterface()).asText();
        this.keyboardWireLength = keyboardNode.get(KeyboardJsonKeys.getKeyboardWireLength()).asText();
        this.isMechanical = keyboardNode.get(KeyboardJsonKeys.getIsMechanical()).asInt();
        this.hasPalmRest = keyboardNode.get(KeyboardJsonKeys.getHasPalmRest()).asInt();
        this.keyboardKeysLayout = keyboardNode.get(KeyboardJsonKeys.getKeyboardKeysLayout()).asText();
        this.hasIllumination = keyboardNode.get(KeyboardJsonKeys.getHasIllumination()).asInt();
        this.ledColour = keyboardNode.get(KeyboardJsonKeys.getLedColour()).asText();
    }

    public int getId() {
        return id;
    }

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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public HardwareItem getHardwareItem() {
        return hardwareItem;
    }

    public void setHardwareItem(HardwareItem hardwareItem) {
        this.hardwareItem = hardwareItem;
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
                ", hardwareItem=" + hardwareItem +
                '}';
    }
}
