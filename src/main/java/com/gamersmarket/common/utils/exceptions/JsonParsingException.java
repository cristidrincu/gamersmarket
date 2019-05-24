/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils.exceptions;

/**
 *
 * @author cristiandrincu
 */
public class JsonParsingException extends RuntimeException {    
    public JsonParsingException(String message) {
        super(message);
    }    
}
