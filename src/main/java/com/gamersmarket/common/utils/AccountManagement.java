/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.gamersmarket.common.enums.messages.AccountManagementMessages;
import com.gamersmarket.common.utils.exceptions.business.accountmanagement.AccountAlreadyExistsException;
import com.gamersmarket.common.utils.exceptions.business.accountmanagement.NoAccountExistsException;
import com.gamersmarket.common.utils.password.PasswordUtils;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Objects;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class AccountManagement {
    
    @Inject
    private GamersRepo gamersRepo;
    
    @Inject
    private PasswordUtils passwordUtils;
    
    public void createAccount(Gamer gamer) {         
        try {
            Gamer newGamer = gamersRepo.getGamerDetails(gamer.getEmail());
            if (!Objects.isNull(newGamer)) {
                throw new AccountAlreadyExistsException(AccountManagementMessages.ACCOUNT_ALREADY_EXISTS.getMessageDescription());
            }
        } catch (NoAccountExistsException e) {
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
