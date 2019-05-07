/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 *
 * @author cristiandrincu
 */
public interface ItemDetailsDTO {
    
    String getHardwareComponentDetails() throws JsonProcessingException;
    
}
