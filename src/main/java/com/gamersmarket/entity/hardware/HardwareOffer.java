package com.gamersmarket.entity.hardware;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gamersmarket.common.deserializers.OfferDeserializer;
import com.gamersmarket.entity.gamers.Gamer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "hardware_offer")
@JsonDeserialize(using = OfferDeserializer.class)
@NamedQueries({
        @NamedQuery(name = HardwareOffer.FIND_HARDWARE_OFFER, query = HardwareOffer.FIND_HARDWARE_OFFER_QUERY),
        @NamedQuery(name = HardwareOffer.FIND_HARDWARE_OFFERS, query = HardwareOffer.FIND_HARDWARE_OFFERS_QUERY)
})
public class HardwareOffer implements Serializable {

    public static final String HARDWARE_OFFER_ID = "id";
    public static final String FIND_HARDWARE_OFFER = "findHardwareOffer";
    public static final String FIND_HARDWARE_OFFER_QUERY = "select hwOffer from HardwareOffer hwOffer where hwOffer.id = :" + HARDWARE_OFFER_ID;
    public static final String FIND_HARDWARE_OFFERS = "findHardwareOffers";
    public static final String FIND_HARDWARE_OFFERS_QUERY = "select hwOffer from HardwareOffer hwOffer";
    private static final long serialVersionUID = 6420963588097220101L;

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
    @JoinColumn(name = "selling_gamer_id")
    private Gamer sellingGamer;

    @ManyToOne
    @JoinColumn(name = "buying_gamer_id")
    private Gamer buyingGamer;

    @ManyToOne
    @JoinColumn(name = "approver_gamer_id")
    private Gamer approverGamer;

    @ManyToOne
    @JoinColumn(name = "winner_bid_id")
    private Gamer winnerBid;

    @ManyToOne
    @JoinColumn(name = "hwitem_id")
    private HardwareItem hardwareItem;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public HardwareOffer() {}

    public HardwareOffer(JsonNode jsonNode) {
        this.approvedByUs = jsonNode.get("approvedByUs").asInt();
        this.buyerRequestsReview = jsonNode.get("buyerRequestsReview").asInt();
        this.updatedOn = new Date();
    }

    public HardwareOffer(int approvedByUs, int buyerRequestsReview) {
        this.approvedByUs = approvedByUs;
        this.buyerRequestsReview = buyerRequestsReview;
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

    public Gamer getSellingGamer() {
        return sellingGamer;
    }

    public void setSellingGamer(Gamer sellingGamer) {
        this.sellingGamer = sellingGamer;
    }

    public Gamer getBuyingGamer() {
        return buyingGamer;
    }

    public void setBuyingGamer(Gamer buyingGamer) {
        this.buyingGamer = buyingGamer;
    }

    public Gamer getApproverGamer() {
        return approverGamer;
    }

    public void setApproverGamer(Gamer approverGamer) {
        this.approverGamer = approverGamer;
    }

    public Gamer getWinnerBid() {
        return winnerBid;
    }

    public void setWinnerBid(Gamer winnerBid) {
        this.winnerBid = winnerBid;
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
        HardwareOffer hardwareOffer = (HardwareOffer) o;
        return id == hardwareOffer.id &&
                createdOn.equals(hardwareOffer.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }

    @Override
    public String toString() {
        return "HardwareOffer{" +
                "id=" + id +
                ", approvedByUs=" + approvedByUs +
                ", buyerRequestsReview=" + buyerRequestsReview +
                ", sellingGamer=" + sellingGamer +
                ", buyingGamer=" + buyingGamer +
                ", approverGamer=" + approverGamer +
                ", winnerBid=" + winnerBid +
                ", hardwareItem=" + hardwareItem +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
