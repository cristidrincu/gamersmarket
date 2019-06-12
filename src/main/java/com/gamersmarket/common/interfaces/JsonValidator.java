/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.interfaces;

import com.fasterxml.jackson.databind.JsonNode;

/**
 *
 * @author cristiandrincu
 */
public interface JsonValidator {
    boolean validateJsonKeys(JsonNode jsonNode);
}
