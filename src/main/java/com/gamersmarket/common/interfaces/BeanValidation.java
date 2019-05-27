/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.interfaces;

import java.util.Set;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author cristiandrincu
 */
public interface BeanValidation {
    Set<String> collectConstraintViolationErrors(ConstraintViolationException e);
}
