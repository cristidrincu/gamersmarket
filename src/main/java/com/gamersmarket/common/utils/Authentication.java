/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.gamersmarket.common.utils.password.PasswordUtils;
import com.gamersmarket.entity.gamers.Gamer;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class Authentication {       
    
    @Inject
    private PasswordUtils passwordUtils;

    public boolean authenticateUser(Gamer user, String providedPassword) {
        return passwordUtils.verifyUserPassword(providedPassword, user.getPassword(), user.getPasswordSalt());        
    }            
}
