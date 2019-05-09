/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.gamersmarket.entity.gamers.Gamer;
import javax.inject.Inject;

/**
 *
 * @author cristiandrincu
 */
public class Authentication {       
    
    @Inject
    private PasswordUtils passwordUtils;
    
    @Inject
    public Authentication() {}        
        
    public boolean authenticateUser(Gamer user, String providedPassword) {
        return passwordUtils.verifyUserPassword(providedPassword, user.getPassword(), user.getPasswordSalt());        
    }            
}
