/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils.exceptions.business.bids;

import com.gamersmarket.common.utils.exceptions.business.BusinessRuleException;

/**
 *
 * @author cristiandrincu
 */
public class HardwareBidAmountException extends BusinessRuleException {
    
    public HardwareBidAmountException(String message) {
        super(message);
    }
}
