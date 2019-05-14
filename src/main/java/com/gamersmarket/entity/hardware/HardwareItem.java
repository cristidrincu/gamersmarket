package com.gamersmarket.entity.hardware;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.jsonkeys.HardwareItemJsonKeys;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.types.HardwareType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hw_item")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "hw_item_discriminator"
)
@NamedQueries({
        @NamedQuery(name = HardwareItem.GET_HARDWARE_ITEM, query = HardwareItem.GET_HARDWARE_ITEM_QUERY),
        @NamedQuery(name = HardwareItem.GET_HARDWARE_ITEMS, query = HardwareItem.GET_HARDWARE_ITEMS_QUERY)
})
public class HardwareItem implements Serializable {

    public static final String PARAM_ID = "id";
    public static final String GET_HARDWARE_ITEM = "HardwareItem.getHardwareItem";
    public static final String GET_HARDWARE_ITEM_QUERY = "select hwItem from HardwareItem hwitem where hwItem.id = :" + PARAM_ID;
    public static final String GET_HARDWARE_ITEMS = "HardwareItem.getHardwareItems";
    public static final String GET_HARDWARE_ITEMS_QUERY = "select hwItem from HardwareItem hwItem";
    private static final long serialVersionUID = 762283048421625510L;

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_item")
    @SequenceGenerator(name = "sq_hardware_item_mouse", sequenceName = "sq_hardware_item")
    private int id;

    @Column
    private String manufacturer;
    
    @Column(name = "manufacturer_code")
    @Size(min = 10, max = 255, message = "Manufacturer code must be between 10 and 255 characters.")
    private String manufacturerCode;

    @Size(min = 10, max = 255, message = "Hardware item name must be between 10 and 50 characters.")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    protected Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    protected Date updatedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hardware_type_id")
    private HardwareType hardwareType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Gamer gamer;
    
    public HardwareItem() {}
    
    public HardwareItem(String manufacturer, String manufacturerCode, String name) {                
        this.manufacturer = manufacturer;
        this.manufacturerCode = manufacturerCode;
        this.name = name;
        this.createdOn = new Date();        
    }

    public HardwareItem(HardwareItem hardwareItem) {
        this.id = hardwareItem.getId();
        this.gamer = hardwareItem.getGamer();
        this.manufacturer = hardwareItem.getManufacturer();
        this.manufacturerCode = hardwareItem.getManufacturerCode();
        this.name = hardwareItem.getName();
        this.createdOn = hardwareItem.getCreatedOn();
        this.updatedOn = new Date();
        this.hardwareType = hardwareItem.getHardwareType();
    }

    public HardwareItem(JsonNode hwItemNode) {
        this.manufacturer = hwItemNode.get(HardwareItemJsonKeys.MANUFACTURER.getJsonKeyDescription()).asText();
        this.manufacturerCode = hwItemNode.get(HardwareItemJsonKeys.MANUFACTURER_CODE.getJsonKeyDescription()).asText();
        this.name = hwItemNode.get(HardwareItemJsonKeys.HW_ITEM_NAME.getJsonKeyDescription()).asText();
        this.updatedOn = new Date();
    }        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }        

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HardwareType getHardwareType() {
        return hardwareType;
    }

    public void setHardwareType(HardwareType hardwareType) {
        this.hardwareType = hardwareType;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HardwareItem hwItem = (HardwareItem) o;
        return this.id == hwItem.id && manufacturerCode.equals(hwItem.manufacturerCode) &&
                createdOn.equals(hwItem.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerCode, createdOn);
    }

    @Override
    public String toString() {
        return "HardwareItem{" +
                "id=" + id +
                ", manufacturerCode='" + manufacturerCode + '\'' +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +                
                '}';
    }
}
