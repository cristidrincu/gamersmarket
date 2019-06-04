package com.gamersmarket.control.gamers;

import com.gamersmarket.common.enums.messages.AccountManagementMessages;
import com.gamersmarket.common.enums.hwbidstates.HardwareBidStates;
import com.gamersmarket.common.interfaces.GamersRepository;
import com.gamersmarket.common.utils.password.PasswordUtils;
import com.gamersmarket.common.utils.exceptions.business.accountmanagement.NoAccountExistsException;
import com.gamersmarket.entity.bid.HardwareBid;
import com.gamersmarket.entity.gamers.Gamer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.NoResultException;

public class GamersRepo implements GamersRepository<Gamer> {

    @Inject
    PasswordUtils passwordUtils;
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createGamer(Gamer gamer) {
        em.persist(gamer);
    }
    
    @Override
    public void updateGamer(Gamer gamer) {
        em.merge(gamer);
    }
    
    @Override
    public Gamer getGamerDetails(int gamerId) {
        try {
            return em.createNamedQuery(Gamer.GET_GAMER_DETAILS, Gamer.class).setParameter(Gamer.PARAM_GAMER_ID, gamerId).getSingleResult();
        } catch (NoResultException e) {
            throw new NoAccountExistsException(AccountManagementMessages.NO_ACCOUNT_FOUND.getMessageDescription());
        }        
    }
    
    @Override
    public Gamer getGamerDetails(String emailAddress) {                        
        try {
            return em.createNamedQuery(Gamer.FIND_GAMER_BY_EMAIL, Gamer.class).setParameter(Gamer.PARAM_GAMER_EMAIL, emailAddress).getSingleResult();
        } catch (NoResultException e) {
            throw new NoAccountExistsException(AccountManagementMessages.NO_ACCOUNT_FOUND.getMessageDescription());
        }                
    }
    
    @Override
    public void deleteGamer(int gamerId) {
        Gamer gamer = getGamerDetails(gamerId);
        em.remove(gamer);
    }       

    @Override
    public List<HardwareBid> getActiveHWBidsForGamer(int gamerId) {
        return em.createNamedQuery(HardwareBid.GET_HARDWARE_BIDS_FOR_GAMER_BASED_ON_BID_STATE, HardwareBid.class)
                .setParameter(HardwareBid.PARAM_GAMER_ID, gamerId)
                .setParameter(HardwareBid.PARAM_BID_STATE, HardwareBidStates.ACTIVE.getStatus())
                .getResultList();
    }

    @Override
    public List<HardwareBid> getWonHWBidsForGamer(int gamerId) {
        return em.createNamedQuery(HardwareBid.GET_HARDWARE_BIDS_FOR_GAMER_BASED_ON_BID_STATE, HardwareBid.class)
                .setParameter(HardwareBid.PARAM_GAMER_ID, gamerId)
                .setParameter(HardwareBid.PARAM_BID_STATE, HardwareBidStates.COMPLETED.getStatus())
                .getResultList();
    }

    @Override
    public List<HardwareBid> getCancelledHWBidsForGamer(int gamerId) {
        return em.createNamedQuery(HardwareBid.GET_HARDWARE_BIDS_FOR_GAMER_BASED_ON_BID_STATE, HardwareBid.class)
                .setParameter(HardwareBid.PARAM_GAMER_ID, gamerId)
                .setParameter(HardwareBid.PARAM_BID_STATE, HardwareBidStates.CANCELLED.getStatus())
                .getResultList();
    }                
}
