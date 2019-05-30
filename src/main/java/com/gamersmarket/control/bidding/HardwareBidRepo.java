/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.control.bidding;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.messages.HardwareBidMessages;
import com.gamersmarket.common.interfaces.BidRepository;
import com.gamersmarket.common.utils.exceptions.business.HardwareBidAmountException;
import com.gamersmarket.common.utils.exceptions.persistence.NoEntityFoundException;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.control.hardware.HardwareOfferRepo;
import com.gamersmarket.entity.bid.HardwareBid;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.HardwareOffer;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cristiandrincu
 */
public class HardwareBidRepo implements BidRepository<HardwareBid> {

    @PersistenceContext(name = "gamersMarket")
    EntityManager em;
    
    @Inject
    HardwareOfferRepo hardwareOfferRepo;
    
    @Inject
    GamersRepo gamersRepo;
    
    @Override
    public HardwareBid getBid(int bidId) {
        try {
            return em.createNamedQuery(HardwareBid.GET_HARDWARE_BID_BASED_ON_ID, HardwareBid.class)
                    .setParameter(HardwareBid.PARAM_HARDWARE_BID_ID, bidId).getSingleResult();
        } catch (NoResultException e) {
            throw new NoEntityFoundException(HardwareBidMessages.HARDWARE_BID_NOT_FOUND_BY_ID.getMessage());
        }
    }
    
    @Override
    public List<HardwareBid> getBids(String bidState) {
        return em.createNamedQuery(HardwareBid.GET_HARDWARE_BIDS_BASED_ON_STATE, HardwareBid.class)
                .setParameter(HardwareBid.PARAM_BID_STATE, bidState).getResultList();
    }
    
    @Override
    public void addBid(HardwareBid bid) {
        em.persist(bid);
    }     
    
    @Override
    public HardwareBid addBid(JsonNode hardwareBidNode, int hardwareOfferId, int bidderId) {
        HardwareBid highestHardwareBid = getHighestHardwareBidPerOffer(hardwareOfferId);
        HardwareBid hardwareBid = new HardwareBid(hardwareBidNode);
        if (hardwareBid.getAmount() == highestHardwareBid.getAmount()) {
            throw new HardwareBidAmountException(HardwareBidMessages.HARDWARE_BID_EQUAL_AMOUNT.getMessage());
        }
        
        if (hardwareBid.getAmount() < highestHardwareBid.getAmount()) {
            throw new HardwareBidAmountException(HardwareBidMessages.HARDWARE_BID_LESS_AMOUNT.getMessage());
        }
        
        HardwareOffer hardwareOffer = hardwareOfferRepo.getItem(hardwareOfferId);
        Gamer bidder = gamersRepo.getGamerDetails(bidderId);
        
        hardwareBid.setHardwareOffer(hardwareOffer);
        hardwareBid.setBidder(bidder);
        
        addBid(hardwareBid);
        return hardwareBid;
    }

    @Override
    public void editBid(HardwareBid bid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editBid(int bidId, JsonNode hardwareBid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBid(int bidId) {
        HardwareBid hwBid = getBid(bidId);
        em.remove(hwBid);
    }

    @Override
    public void deleteBid(HardwareBid bid) {
        em.remove(bid);
    }
    
    public HardwareBid getHighestHardwareBidPerOffer(int hardwareOfferId) {
        try {
            return em.createNamedQuery(HardwareBid.GET_HIGHEST_BID_PER_HARDWARE_OFFER_ID, HardwareBid.class)
                .setParameter(HardwareBid.PARAM_HARDWARE_OFFER_ID, hardwareOfferId)
                .getSingleResult();
        } catch(NoResultException ex) {
            throw new NoEntityFoundException(HardwareBidMessages.HARDWARE_BID_NOT_FOUND_FOR_OFFER.getMessage());
        }
    }
}
