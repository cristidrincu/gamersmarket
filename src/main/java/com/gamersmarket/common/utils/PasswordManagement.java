/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;
import javax.inject.Inject;

/**
 *
 * @author cristiandrincu
 */
public class PasswordManagement {
        
    @Inject
    GamersRepo gamersRepo;
    
    public void resetPassword(int gamerId, String newPassword) {
        Gamer gamer = gamersRepo.getGamerDetails(gamerId);
        gamer.setPassword(newPassword);
        gamersRepo.updateGamer(gamer);
    }
}
