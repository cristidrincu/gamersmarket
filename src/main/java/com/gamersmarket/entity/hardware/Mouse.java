package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.constants.MouseJsonKeys;
import com.gamersmarket.deserializers.MouseDeserializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hw_item_mouse")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonDeserialize(using = MouseDeserializer.class)
@NamedQueries({
        @NamedQuery(name = Mouse.GET_MOUSE_DETAILS, query = "select m from Mouse m where m.id = :id"),
        @NamedQuery(name = Mouse.GET_ITEMS, query = "select m from Mouse m")
})
public class Mouse implements Serializable {

    private static final long serialVersionUID = 8821921956251827118L;

    public static final String GET_MOUSE_DETAILS = "Mouse.getMouseDetails";
    public static final String GET_ITEMS = "Mouse.getMice";

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_item")
    @SequenceGenerator(name = "sq_hardware_item_mouse", sequenceName = "sq_hardware_item")
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

    public Mouse() {}

    public Mouse(Mouse mouse) {
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
        this.updatedOn = new Date();
    }

    public Mouse(JsonNode mouseNode) {
        this.connectionType = mouseNode.get(MouseJsonKeys.getConnectionType()).asText();
        this.sensorTechnology = mouseNode.get(MouseJsonKeys.getSensorTechnology()).asText();
        this.buttons = mouseNode.get(MouseJsonKeys.getButtons()).asInt();
        this.scrollingButtons = mouseNode.get(MouseJsonKeys.getScrollingButtons()).asInt();
        this.colour = mouseNode.get(MouseJsonKeys.getColour()).asText();
        this.hasIllumination = mouseNode.get(MouseJsonKeys.getHasIllumination()).asInt();
        this.ledColor = mouseNode.get(MouseJsonKeys.getLedColor()).asText();
        this.cableLength = mouseNode.get(MouseJsonKeys.getCableLength()).asText();
        this.weight = mouseNode.get(MouseJsonKeys.getWeight()).asText();
        this.dpi = mouseNode.get(MouseJsonKeys.getDpi()).asInt();
        this.isWireless = mouseNode.get(MouseJsonKeys.getIsWireless()).asInt();
        this.updatedOn = new Date();
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
        Mouse mouse = (Mouse) o;
        return id == mouse.id &&
                createdOn.equals(mouse.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }

    @Override
    public String toString() {
        return "Mouse{" +
                ", connectionType='" + connectionType + '\'' +
                ", sensorTechnology='" + sensorTechnology + '\'' +
                ", buttons=" + buttons +
                ", scrollingButtons=" + scrollingButtons +
                ", colour=" + colour +
                ", hasIllumination=" + hasIllumination +
                ", ledColor='" + ledColor + '\'' +
                ", cableLength='" + cableLength + '\'' +
                ", weight='" + weight + '\'' +
                ", dpi=" + dpi +
                ", isWireless=" + isWireless +
                '}';
    }
}
