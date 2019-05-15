package com.gamersmarket.entity.bid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.deserializers.HardwareBidDeserializer;
import com.gamersmarket.common.enums.jsonkeys.HardwareBidJsonKeys;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.HardwareOffer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hardware_bid")
@NamedQueries({
    @NamedQuery(name = HardwareBid.GET_HARDWARE_BIDS_FOR_GAMER_BASED_ON_BID_STATE, query = HardwareBid.GET_HARDWARE_BIDS_FOR_GAMER_BASED_ON_BID_STATE_QUERY),
    @NamedQuery(name = HardwareBid.GET_HARDWARE_BID_BASED_ON_ID, query = HardwareBid.GET_HARDWARE_BID_BASED_ON_ID_QUERY)
        
})
@JsonDeserialize(using = HardwareBidDeserializer.class)
public class HardwareBid implements Serializable {

    private static final long serialVersionUID = -2355384513180239447L;
    public static final String PARAM_HARDWARE_BID_ID = "hardwareBidId";
    public static final String PARAM_GAMER_ID = "id";
    public static final String PARAM_BID_STATE = "bidState";
    public static final String GET_HARDWARE_BID_BASED_ON_ID = "getHardwareBidBasedOnId";
    public static final String GET_HARDWARE_BID_BASED_ON_ID_QUERY = "select hwBid from HardwareBid hwBid where hwBid.id = :" + PARAM_HARDWARE_BID_ID;
    public static final String GET_HARDWARE_BIDS_FOR_GAMER_BASED_ON_BID_STATE = "getHardwareBidsBasedOnState";
    public static final String GET_HARDWARE_BIDS_FOR_GAMER_BASED_ON_BID_STATE_QUERY = "select hwBid from HardwareBid hwBid where hwBid.bidder.id = :" 
            + PARAM_GAMER_ID + " and hwBid.bidState = :" + PARAM_BID_STATE;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hardware_bid_generator")   
    @SequenceGenerator(name = "hardware_bid_generator", sequenceName = "sq_hardware_bid")
    private int id;

    private double amount;

    @Column(name = "bid_state")
    private String bidState;

    @ManyToOne
    @JoinColumn(name = "gamer_id")
    private Gamer bidder;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private HardwareOffer hardwareOffer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public HardwareBid() {}

    public HardwareBid(HardwareBid hardwareBid) {
        this.id = hardwareBid.getId();
        this.amount = hardwareBid.getAmount();
        this.bidState = hardwareBid.getBidState();
        this.updatedOn = new Date();
    }

    public HardwareBid(JsonNode hardwareBidNode) {
        this.amount = hardwareBidNode.get(HardwareBidJsonKeys.AMOUNT.getJsonKeyDescription()).asDouble();
        this.bidState = hardwareBidNode.get(HardwareBidJsonKeys.BID_STATE.getJsonKeyDescription()).asText();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBidState() {
        return bidState;
    }

    public void setBidState(String bidState) {
        this.bidState = bidState;
    }

    public Gamer getBidder() {
        return bidder;
    }

    public void setBidder(Gamer bidder) {
        this.bidder = bidder;
    }

    public HardwareOffer getHardwareOffer() {
        return hardwareOffer;
    }

    public void setHardwareOffer(HardwareOffer hardwareOffer) {
        this.hardwareOffer = hardwareOffer;
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
        HardwareBid that = (HardwareBid) o;
        return id == that.id &&
                createdOn.equals(that.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }

    @Override
    public String toString() {
        return "HardwareBid{" +
                "id=" + id +
                ", amount=" + amount +
                ", bidState='" + bidState + '\'' +
                ", bidder=" + bidder +
                ", hardwareOffer=" + hardwareOffer +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
