package com.gamersmarket.control.hardware;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.hwofferstates.HardwareOfferStates;
import com.gamersmarket.common.enums.jsonkeys.HardwareOfferJsonKeys;
import com.gamersmarket.common.enums.messages.BeanValidationMessages;
import com.gamersmarket.common.enums.messages.NoResultsFoundMessages;
import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.common.utils.exceptions.persistence.EntityValidationException;
import com.gamersmarket.common.utils.exceptions.persistence.NoEntityFoundException;
import com.gamersmarket.common.utils.template.hardware.HardwareOfferTemplate;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.control.pricing.HardwarePricingRepo;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.HardwareOffer;
import com.gamersmarket.entity.pricing.HardwarePricing;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

public class HardwareOfferRepo implements HardwareRepository<HardwareOffer>, BeanValidation {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;

    @Inject
    private HardwareOfferTemplate hardwareOfferTemplate;
    
    @Inject
    GamersRepo gamersRepo;        
    
    @Inject
    HardwarePricingRepo hardwarePricingRepo;
    
    public HardwareOfferRepo() {}

    @Override
    public List<HardwareOffer> getItems() {
        return em.createNamedQuery(HardwareOffer.FIND_HARDWARE_OFFERS, HardwareOffer.class).getResultList();
    }

    @Override
    public HardwareOffer getItem(int hardwareId) {
        try {
            return em.createNamedQuery(HardwareOffer.FIND_HARDWARE_OFFER, HardwareOffer.class)
                    .setParameter(HardwareOffer.HARDWARE_OFFER_ID, hardwareId).getSingleResult();
        } catch (NoResultException e) {
            throw new NoEntityFoundException(NoResultsFoundMessages.HARDWARE_OFFER_NOT_FOUND_BY_ID.getErrorMessage());
        }        
    }

    @Override
    public void addItem(HardwareOffer hardwareOffer) {
        try {
            em.persist(hardwareOffer);
        } catch (ConstraintViolationException e) {            
            throw new EntityValidationException(BeanValidationMessages.FAILED_CONSTRAINT_VALIDATION.getMessage(),
                    collectConstraintViolationErrors(e));
       }        
    }
    
    @Override
    public void updateItem(HardwareOffer hardwareOffer) {
        em.merge(hardwareOffer);
    }

    @Override
    public void deleteItem(int hardwareId) {
        HardwareOffer hardwareOffer = this.getItem(hardwareId);
        em.remove(hardwareOffer);
    }

    public void buildInitialHardwareOffer(JsonNode initialHardwareOfferJson, JsonNode hwPricingNode) {
        Map<String, Object> initialHardwareOfferDependencies = hardwareOfferTemplate.buildInitialHardwareOffer(initialHardwareOfferJson);

        int approvedByUs = (int) initialHardwareOfferDependencies.get(HardwareOfferJsonKeys.APPROVED_BY_US.getJsonKeyDescription());
        int buyerRequestsReview = (int) initialHardwareOfferDependencies.get(HardwareOfferJsonKeys.BUYER_REQUESTS_REVIEW.getJsonKeyDescription());
        String hardwareOfferState = (String) initialHardwareOfferDependencies.get(HardwareOfferJsonKeys.HARDWARE_OFFER_STATE.getJsonKeyDescription());

        Gamer sellingGamer = (Gamer) initialHardwareOfferDependencies.get(HardwareOfferJsonKeys.SELLING_GAMER_ID.getJsonKeyDescription());
        HardwareItem hwItem = (HardwareItem) initialHardwareOfferDependencies.get(HardwareOfferJsonKeys.HARDWARE_ITEM_ID.getJsonKeyDescription());        

        HardwareOffer hardwareOffer = new HardwareOffer(approvedByUs, buyerRequestsReview);
        HardwarePricing hardwarePricing = new HardwarePricing(hwPricingNode);
        
        hardwareOffer.setSellingGamer(sellingGamer);
        hardwareOffer.setHardwareItem(hwItem);
        hardwareOffer.setHardwareOfferState(hardwareOfferState);
                
        hardwarePricing.setHardwareItem(hwItem);

        hardwarePricingRepo.addPricing(hardwarePricing);
        addItem(hardwareOffer);
    }

    public void buildFinalHardwareOffer(JsonNode completeHardwareOfferJson) {
        Map<String, Object> completeHardwareOfferDependencies = hardwareOfferTemplate.buildFinalHardwareOffer(completeHardwareOfferJson);

        int hardwareOfferId = completeHardwareOfferJson.get(HardwareOfferJsonKeys.HARDWARE_OFFER_ID.getJsonKeyDescription()).asInt();
        HardwareOffer hardwareOffer = getItem(hardwareOfferId);

        Gamer buyingGamer = (Gamer) completeHardwareOfferDependencies.get(HardwareOfferJsonKeys.BUYING_GAMER_ID.getJsonKeyDescription());
        Gamer approverGamer = (Gamer) completeHardwareOfferDependencies.get(HardwareOfferJsonKeys.APPROVER_GAMER_ID.getJsonKeyDescription());
        Gamer bidWinner = (Gamer) completeHardwareOfferDependencies.get(HardwareOfferJsonKeys.WINNER_BID_ID.getJsonKeyDescription());

        hardwareOffer.setBuyingGamer(buyingGamer);
        hardwareOffer.setApproverGamer(approverGamer);
        hardwareOffer.setWinnerBid(bidWinner);
        hardwareOffer.setHardwareOfferState(HardwareOfferStates.ACTIVE.getHardwareOfferState());
        hardwareOffer.setUpdatedOn(new Date());

        updateItem(hardwareOffer);
    }
    
    public List<HardwareOffer> getHardwareOffersBasedOnState(String hwOfferState) {
        return em.createNamedQuery(HardwareOffer.FIND_HARDWARE_OFFERS_BASED_ON_STATE, HardwareOffer.class)
                 .setParameter(HardwareOffer.HARDWARE_OFFER_STATE_PARAM, hwOfferState)
                 .getResultList();
    }
    
    public void hardwareOfferEnterActiveState(int hardwareOfferId) {
        HardwareOffer hwOffer = getItem(hardwareOfferId);
        hwOffer.setHardwareOfferState(HardwareOfferStates.ACTIVE.getHardwareOfferState());
        em.merge(hwOffer);
    }
    
    public void hardwareOfferEnterPendingState(int hardwareOfferId) {
        HardwareOffer hwOffer = getItem(hardwareOfferId);
        hwOffer.setHardwareOfferState(HardwareOfferStates.PENDING.getHardwareOfferState());
        em.merge(hwOffer);
    }
    
    public void hardwareOfferEnterCancelledState(int hardwareOfferId) {
        HardwareOffer hwOffer = getItem(hardwareOfferId);
        hwOffer.setHardwareOfferState(HardwareOfferStates.CANCELLED.getHardwareOfferState());
        em.merge(hwOffer);
    }

    @Override
    public void persistItemWithHardwareType(HardwareOffer hardwareItem, int hardwareTypeId, int gamerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> collectConstraintViolationErrors(ConstraintViolationException e) {
        Set<String> constraintViolations = new HashSet<>();
        e.getConstraintViolations().forEach(violation -> constraintViolations.add(violation.getMessageTemplate()));
        return constraintViolations;
    }

    @Override
    public HardwareOffer getItem(String language, int hardwareId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
