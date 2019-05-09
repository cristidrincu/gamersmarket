package com.gamersmarket.control.gamers;

import com.gamersmarket.common.enums.HardwareBidStates;
import com.gamersmarket.common.interfaces.GamersRepository;
import com.gamersmarket.common.utils.PasswordUtils;
import com.gamersmarket.common.utils.exceptions.AccountAlreadyExistsException;
import com.gamersmarket.entity.bid.HardwareBid;
import com.gamersmarket.entity.gamers.Gamer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.inject.Inject;

public class GamersRepo implements GamersRepository<Gamer> {

    @Inject
    PasswordUtils passwordUtils;
    
    @PersistenceContext
    EntityManager em;

    @Override
    public Gamer getGamerDetails(int gamerId) {
        return em.createNamedQuery(Gamer.GET_GAMER_DETAILS, Gamer.class).setParameter(Gamer.PARAM_GAMER_ID, gamerId).getSingleResult();
    }

    @Override
    public void createAccount(Gamer gamer) {
      List<Gamer> existingAccount = getExistingAccount(gamer.getEmail());
      if (!existingAccount.isEmpty()) {
          throw new AccountAlreadyExistsException("An account with this email address already exists!");
      }
      
      String gamerPassword = gamer.getPassword();
      String passwordSalt = passwordUtils.getSalt(30);
      String securedPassword = passwordUtils.generateSecurePassword(gamerPassword, passwordSalt);
      gamer.setPasswordSalt(passwordSalt);
      gamer.setPassword(securedPassword);
      
      em.persist(gamer);
    }

    @Override
    public void resetPassword(int gamerId, String newPassword) {
        Gamer gamer = getGamerDetails(gamerId);
        gamer.setPassword(newPassword);
        em.merge(gamer);
    }

    @Override
    public void cancelAccount(int gamerId) {
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

    private List<Gamer> getExistingAccount(String email) {
        return em.createNamedQuery(Gamer.FIND_GAMER_BY_EMAIL, Gamer.class).setParameter(Gamer.PARAM_GAMER_EMAIL, email).getResultList();
    }
}
