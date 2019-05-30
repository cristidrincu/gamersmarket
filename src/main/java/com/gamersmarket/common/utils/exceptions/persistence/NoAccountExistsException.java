/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils.exceptions.persistence;

import javax.persistence.NoResultException;

/**
 *
 * @author cristiandrincu
 */
public class NoAccountExistsException extends NoResultException {
    public NoAccountExistsException(String message) {
        super(message);
    }
}
