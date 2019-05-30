/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.gamersmarket.common.utils.password.PasswordUtils;
import com.gamersmarket.common.enums.messages.AccountManagementMessages;
import com.gamersmarket.common.utils.exceptions.persistence.AccountAlreadyExistsException;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;
import java.util.Objects;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author cristiandrincu
 */
public class AccountManagement {
    
    @Inject
    private GamersRepo gamersRepo;
    
    @Inject
    private PasswordUtils passwordUtils;
    
    @Inject
    public AccountManagement() {};
    
    public void createAccount(Gamer gamer) {         
        try {
            Gamer newGamer = gamersRepo.getGamerDetails(gamer.getEmail());
            if (!Objects.isNull(newGamer)) {
                throw new AccountAlreadyExistsException(AccountManagementMessages.ACCOUNT_ALREADY_EXISTS.getMessageDescription());
            }
        } catch (NoResultException e) {
            String gamerPassword = gamer.getPassword();
            String passwordSalt = passwordUtils.getSalt(30);
            String securedPassword = passwordUtils.generateSecurePassword(gamerPassword, passwordSalt);
            gamer.setPasswordSalt(passwordSalt);
            gamer.setPassword(securedPassword);
      
            gamersRepo.createGamer(gamer);
        }                          
    }
    
    public void deleteAccount(int gamerId) {        
        gamersRepo.deleteGamer(gamerId);
    }    
}
