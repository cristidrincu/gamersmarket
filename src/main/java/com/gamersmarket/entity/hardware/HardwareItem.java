package com.gamersmarket.entity.hardware;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.deserializers.HardwareItemDeserializer;
import com.gamersmarket.entity.types.HardwareType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hw_item")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonDeserialize(using = HardwareItemDeserializer.class)
@NamedQueries({
        @NamedQuery(name = HardwareItem.GET_HARDWARE_ITEM, query = "select hwItem from HardwareItem hwitem where hwItem.id = :id")
})
public class HardwareItem implements Serializable {

    public static final String GET_HARDWARE_ITEM = "HardwareItem.getHardwareItem";
    private static final long serialVersionUID = 762283048421625510L;

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_item")
    @SequenceGenerator(name = "sq_hardware_item_mouse", sequenceName = "sq_hardware_item")
    private int id;

    @Column(name = "manufacturer_code")
    @Size(min = 10, max = 255, message = "Manufacturer code must be between 10 and 255 characters.")
    private String manufacturerCode;

    @Size(min = 10, max = 255, message = "Hardware item name must be between 10 and 50 characters.")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardware_type_id")
    private HardwareType hardwareType;

    public HardwareItem() {}

    public HardwareItem(HardwareItem hardwareItem) {
        this.id = hardwareItem.getId();
        this.manufacturerCode = hardwareItem.getManufacturerCode();
        this.name = hardwareItem.getName();
        this.createdOn = hardwareItem.getCreatedOn();
        this.updatedOn = new Date();
        this.hardwareType = hardwareItem.getHardwareType();
    }

    public HardwareItem(JsonNode hwItemNode) {
        this.manufacturerCode = hwItemNode.get("manufacturerCode").asText();
        this.name = hwItemNode.get("name").asText();
        this.updatedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", hardwareType=" + hardwareType +
                '}';
    }
}
