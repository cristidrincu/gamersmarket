package com.gamersmarket.entity.pricing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.manufacturer.Manufacturer;
import com.gamersmarket.entity.types.HardwareType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hardware_item_pricing")
@NamedQueries({
    @NamedQuery(name = HardwarePricing.GET_HARDWARE_PRICING_LIST, query = "select p from HardwarePricing p"),
    @NamedQuery(name = HardwarePricing.GET_HARDWARE_PRICING, query = "select p from HardwarePricing p where p.id = :id")
})
public class HardwarePricing implements Serializable {

    private static final long serialVersionUID = -6567167957953246122L;

    public static final String GET_HARDWARE_PRICING_LIST = "HardwarePricing.getHardwarePricingList";
    public static final String GET_HARDWARE_PRICING = "HardwarePricing.getHardwarePricing";

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_item")
    @SequenceGenerator(name = "sq_hardware_item", sequenceName = "sq_hardware_item", initialValue = 50, allocationSize = 1)
    private int id;

    @Column(name = "sell_period_hours")
    private int sellPeriodHours;

    @Column(name = "min_price")
    private int minPrice;

    @Column(name = "recommended_price")
    private int recommendedPrice;

    @Column(name = "has_warranty")
    private int hasWarranty;

    private int age;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "hw_item_id")
    private HardwareItem hardwareItem;

    @ManyToOne
    @JoinColumn(name = "gamer_id")
    private Gamer gamer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public HardwarePricing() {}

    public HardwarePricing(HardwarePricing newPricing) {
        this.age = newPricing.getAge();
        this.hasWarranty = newPricing.getHasWarranty();
        this.minPrice = newPricing.getMinPrice();
        this.recommendedPrice = newPricing.getRecommendedPrice();
        this.sellPeriodHours = newPricing.getSellPeriodHours();
        this.updatedOn = new Date();
    }

    public HardwarePricing(JsonNode hardwarePricingNode) {
        this.age = hardwarePricingNode.get("age").asInt();
        this.hasWarranty = hardwarePricingNode.get("hasWarranty").asInt();
        this.minPrice = hardwarePricingNode.get("minPrice").asInt();
        this.recommendedPrice = hardwarePricingNode.get("recommendedPrice").asInt();
        this.sellPeriodHours = hardwarePricingNode.get("sellPeriodHouse").asInt();
        this.updatedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSellPeriodHours() {
        return sellPeriodHours;
    }

    public void setSellPeriodHours(int sellPeriodHours) {
        this.sellPeriodHours = sellPeriodHours;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getRecommendedPrice() {
        return recommendedPrice;
    }

    public void setRecommendedPrice(int recommendedPrice) {
        this.recommendedPrice = recommendedPrice;
    }

    public int getHasWarranty() {
        return hasWarranty;
    }

    public void setHasWarranty(int hasWarranty) {
        this.hasWarranty = hasWarranty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public HardwareItem getHardwareItem() {
        return hardwareItem;
    }

    public void setHardwareItem(HardwareItem hardwareItem) {
        this.hardwareItem = hardwareItem;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HardwarePricing that = (HardwarePricing) o;
        return id == that.id &&
                createdOn.equals(that.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }
}
