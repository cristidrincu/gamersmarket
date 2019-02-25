package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.deserializers.OfferDeserializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hardware_offer")
@JsonDeserialize(using = OfferDeserializer.class)
public class Offer {

    @Id
    @NotNull
    @GeneratedValue(generator = "sq_hardware_item")
    @SequenceGenerator(name = "sq_hardware_offer", sequenceName = "sq_hardware_item")
    private int id;

    @Column(name = "approved_by_us")
    private int approvedByUs;

    @Column(name = "buyer_requests_review")
    private int buyerRequestsReview;

    @ManyToOne
    private HardwareItem hardwareItem;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public Offer() {}

    public Offer(JsonNode jsonNode) {
        this.approvedByUs = jsonNode.get("approvedByUs").asInt();
        this.buyerRequestsReview = jsonNode.get("buyerRequestsReview").asInt();
        this.updatedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApprovedByUs() {
        return approvedByUs;
    }

    public void setApprovedByUs(int approvedByUs) {
        this.approvedByUs = approvedByUs;
    }

    public int getBuyerRequestsReview() {
        return buyerRequestsReview;
    }

    public void setBuyerRequestsReview(int buyerRequestsReview) {
        this.buyerRequestsReview = buyerRequestsReview;
    }

    public HardwareItem getHardwareItem() {
        return hardwareItem;
    }

    public void setHardwareItem(HardwareItem hardwareItem) {
        this.hardwareItem = hardwareItem;
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
        Offer offer = (Offer) o;
        return id == offer.id &&
                createdOn.equals(offer.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }
}
