package com.gamersmarket.common.utils.exceptions.persistence;


import javax.persistence.PersistenceException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristiandrincu
 */
public class DuplicateEntryException extends PersistenceException {
    
    public DuplicateEntryException(String message) {
        super(message);
    }
    
}
