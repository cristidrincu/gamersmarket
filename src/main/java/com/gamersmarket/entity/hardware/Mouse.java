package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.enums.jsonkeys.MouseJsonKeys;
import com.gamersmarket.common.deserializers.MouseDeserializer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hw_item_mouse")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("Mouse")
@JsonDeserialize(using = MouseDeserializer.class)
@NamedQueries({
        @NamedQuery(name = Mouse.GET_MICE, query = Mouse.GET_MICE_QUERY),
        @NamedQuery(name = Mouse.GET_MOUSE_DETAILS, query = Mouse.GET_MOUSE_DETAILS_QUERY)        
})
public class Mouse extends HardwareItem implements Serializable {

    private static final long serialVersionUID = 8821921956251827118L;

    public static final String MOUSE_PARAM_ID = "id";

    public static final String GET_MICE = "Mouse.getMice";
    public static final String GET_MOUSE_DETAILS = "Mouse.getMouseDetails";

    public static final String GET_MICE_QUERY = "select m from Mouse m";
    public static final String GET_MOUSE_DETAILS_QUERY = "select m from Mouse m where m.id = :" + MOUSE_PARAM_ID;      

    @Id
    @NotNull
    private int id;        

    @Column(name = "connection_type")
    private String connectionType;

    @Column(name = "sensor_technology")
    private String sensorTechnology;

    private int buttons;

    @Column(name = "scrolling_buttons")
    private int scrollingButtons;

    @Size(min = 4, max = 50, message = "Colour name must be between 10 and 50 characters long.")
    private String colour;

    @Column(name = "has_illumination")
    private int hasIllumination;

    @Column(name = "led_color")
    private String ledColor;

    @Column(name = "cable_length")
    private String cableLength;

    private String weight;
    
    private int dpi;

    @Column(name = "is_wireless")
    private int isWireless;            

    public Mouse() {
        super();
    }
    
    public Mouse(Mouse mouse, String name, String manufacturerCode) {        
        super(name, manufacturerCode);
        this.id = mouse.getId();
        this.connectionType = mouse.getConnectionType();
        this.sensorTechnology = mouse.getSensorTechnology();
        this.buttons = mouse.getButtons();
        this.scrollingButtons = mouse.getScrollingButtons();
        this.colour = mouse.getColour();
        this.hasIllumination = mouse.getHasIllumination();
        this.ledColor = mouse.getLedColor();
        this.cableLength = mouse.getCableLength();
        this.weight = mouse.getWeight();
        this.dpi = mouse.getDpi();
        this.isWireless = mouse.getIsWireless();
    }

    public Mouse(JsonNode mouseNode) {
        super(mouseNode.get("manufacturerCode").asText(), mouseNode.get("name").asText());
        this.connectionType = mouseNode.get(MouseJsonKeys.CONNECTION_TYPE.getJsonKeyDescription()).asText();
        this.sensorTechnology = mouseNode.get(MouseJsonKeys.SENSOR_TECHNOLOGY.getJsonKeyDescription()).asText();
        this.buttons = mouseNode.get(MouseJsonKeys.BUTTONS.getJsonKeyDescription()).asInt();
        this.scrollingButtons = mouseNode.get(MouseJsonKeys.SCROLLING_BUTTONS.getJsonKeyDescription()).asInt();
        this.colour = mouseNode.get(MouseJsonKeys.COLOUR.getJsonKeyDescription()).asText();
        this.hasIllumination = mouseNode.get(MouseJsonKeys.HAS_ILLUMINATION.getJsonKeyDescription()).asInt();
        this.ledColor = mouseNode.get(MouseJsonKeys.LED_COLOR.getJsonKeyDescription()).asText();
        this.cableLength = mouseNode.get(MouseJsonKeys.CABLE_LENGTH.getJsonKeyDescription()).asText();
        this.weight = mouseNode.get(MouseJsonKeys.WEIGHT.getJsonKeyDescription()).asText();
        this.dpi = mouseNode.get(MouseJsonKeys.DPI.getJsonKeyDescription()).asInt();
        this.isWireless = mouseNode.get(MouseJsonKeys.IS_WIRELESS.getJsonKeyDescription()).asInt();      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getSensorTechnology() {
        return sensorTechnology;
    }

    public void setSensorTechnology(String sensorTechnology) {
        this.sensorTechnology = sensorTechnology;
    }

    public int getButtons() {
        return buttons;
    }

    public void setButtons(int buttons) {
        this.buttons = buttons;
    }

    public int getScrollingButtons() {
        return scrollingButtons;
    }

    public void setScrollingButtons(int scrollingButtons) {
        this.scrollingButtons = scrollingButtons;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getHasIllumination() {
        return hasIllumination;
    }

    public void setHasIllumination(int hasIllumination) {
        this.hasIllumination = hasIllumination;
    }

    public String getLedColor() {
        return ledColor;
    }

    public void setLedColor(String ledColor) {
        this.ledColor = ledColor;
    }

    public String getCableLength() {
        return cableLength;
    }

    public void setCableLength(String cableLength) {
        this.cableLength = cableLength;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public int getIsWireless() {
        return isWireless;
    }

    public void setIsWireless(int isWireless) {
        this.isWireless = isWireless;
    } 
}
