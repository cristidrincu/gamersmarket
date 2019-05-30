/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils.exceptions.persistence;

import java.util.Set;

/**
 *
 * @author cristiandrincu
 */
public class EntityValidationException extends RuntimeException {                   

    private Set<String> errors;            
    
    public EntityValidationException(String message) {
        super(message);
    }
    
    public EntityValidationException(String message, Set<String> errors) {
        super(message);
        this.errors = errors;
    }   

    public Set<String> getErrors() {
        return errors;
    }       
}
