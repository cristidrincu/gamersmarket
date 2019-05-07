package com.gamersmarket.control.hardware;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.HardwareOfferJsonFields;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.common.utils.template.hardware.HardwareOfferTemplate;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.HardwareOffer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HardwareOfferRepo implements HardwareRepository<HardwareOffer> {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private HardwareOfferTemplate hardwareOfferTemplate;
    
    public HardwareOfferRepo() {}

    @Override
    public List<HardwareOffer> getItems() {
        return em.createNamedQuery(HardwareOffer.FIND_HARDWARE_OFFERS, HardwareOffer.class).getResultList();
    }

    @Override
    public HardwareOffer getItem(int hardwareId) {
        return em.createNamedQuery(HardwareOffer.FIND_HARDWARE_OFFER, HardwareOffer.class)
                .setParameter(HardwareOffer.HARDWARE_OFFER_ID, hardwareId).getSingleResult();
    }

    @Override
    public void addItem(HardwareOffer hardwareItem) {
        em.persist(hardwareItem);
    }

    @Override
    public void deleteItem(int hardwareId) {
        HardwareOffer hardwareOffer = this.getItem(hardwareId);
        em.remove(hardwareOffer);
    }

    public void buildInitialHardwareOffer(JsonNode initialHardwareOfferJson) {
        Map<String, Object> initialHardwareOfferDependencies = hardwareOfferTemplate.buildInitialHardwareOffer(initialHardwareOfferJson);

        int approvedByUs = (int) initialHardwareOfferDependencies.get(HardwareOfferJsonFields.APPROVED_BY_US.getFieldName());
        int buyerRequestsReview = (int) initialHardwareOfferDependencies.get(HardwareOfferJsonFields.BUYER_REQUESTS_REVIEW.getFieldName());

        Gamer sellingGamer = (Gamer) initialHardwareOfferDependencies.get(HardwareOfferJsonFields.SELLING_GAMER_ID.getFieldName());
        HardwareItem hwItem = (HardwareItem) initialHardwareOfferDependencies.get(HardwareOfferJsonFields.HARDWARE_ITEM_ID.getFieldName());

        HardwareOffer hardwareOffer = new HardwareOffer(approvedByUs, buyerRequestsReview);
        hardwareOffer.setSellingGamer(sellingGamer);
        hardwareOffer.setHardwareItem(hwItem);

        em.persist(hardwareOffer);
    }

    public void buildFinalHardwareOffer(JsonNode completeHardwareOfferJson) {
        Map<String, Object> completeHardwareOfferDependencies = hardwareOfferTemplate.buildFinalHardwareOffer(completeHardwareOfferJson);

        int hardwareOfferId = completeHardwareOfferJson.get(HardwareOfferJsonFields.HARDWARE_OFFER_ID.getFieldName()).asInt();
        HardwareOffer hardwareOffer = getItem(hardwareOfferId);

        Gamer buyingGamer = (Gamer) completeHardwareOfferDependencies.get(HardwareOfferJsonFields.BUYING_GAMER_ID.getFieldName());
        Gamer approverGamer = (Gamer) completeHardwareOfferDependencies.get(HardwareOfferJsonFields.APPROVER_GAMER_ID.getFieldName());
        Gamer bidWinner = (Gamer) completeHardwareOfferDependencies.get(HardwareOfferJsonFields.WINNER_BID_ID.getFieldName());

        hardwareOffer.setBuyingGamer(buyingGamer);
        hardwareOffer.setApproverGamer(approverGamer);
        hardwareOffer.setWinnerBid(bidWinner);
        hardwareOffer.setUpdatedOn(new Date());

        em.merge(hardwareOffer);
    }
}
