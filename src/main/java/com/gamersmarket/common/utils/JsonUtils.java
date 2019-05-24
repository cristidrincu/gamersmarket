/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.jsonkeys.GamerJsonKeys;
import com.gamersmarket.common.enums.jsonkeys.HardwareBidJsonKeys;
import com.gamersmarket.common.enums.jsonkeys.SecondaryFieldsHardwareItem;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.exceptions.JsonParsingException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author cristiandrincu
 */
public class JsonUtils {
        
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());
    
    @Inject
    private ObjectMapperProvider provider;
    
    @Inject
    public JsonUtils() {}
    
    public JsonNode readJsonTree(String json) throws IOException {
        return provider.getContext(JsonUtils.class).readTree(json);
    }
    
    public int readHwTypeIdFromNode(String json) throws IOException {
        JsonNode hwTypeNode = readJsonTree(json).get(SecondaryFieldsHardwareItem.HW_TYPE_ROOT_NODE.getJsonKeyDescription());
        if (hwTypeNode == null) {
            LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", "hwType");
            throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.", "hwType"));        
        } else {
            JsonNode hwTypeId = hwTypeNode.get(SecondaryFieldsHardwareItem.HW_TYPE_ID.getJsonKeyDescription());
            if (hwTypeId == null) {
                LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", "hwType->id");
                throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.", "hwType->id"));        
            }
        }
        return readJsonTree(json)
                .get(SecondaryFieldsHardwareItem.HW_TYPE_ROOT_NODE.getJsonKeyDescription())
                .get(SecondaryFieldsHardwareItem.HW_TYPE_ID.getJsonKeyDescription())
                .asInt();
    }
    
    public int readGamerIdFromNode(String json) throws IOException {
        JsonNode gamerNode = readJsonTree(json).get(SecondaryFieldsHardwareItem.GAMER_ROOT_NODE.getJsonKeyDescription());                
        if (gamerNode == null) {
            LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", "gamer");
            throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.", "gamer"));        
        } else {
            JsonNode gamerId = gamerNode.get(SecondaryFieldsHardwareItem.GAMER_ID.getJsonKeyDescription());
            if (gamerId == null) {
                LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", "id");
                throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.", "gamer->id"));        
            }
        }
        return readJsonTree(json)
                .get(SecondaryFieldsHardwareItem.GAMER_ROOT_NODE.getJsonKeyDescription())
                .get(SecondaryFieldsHardwareItem.GAMER_ID.getJsonKeyDescription())
                .asInt();
    }
    
    public int readHardwareOfferIdFromNode(String json) throws IOException {
        JsonNode hardwareOfferId = readJsonTree(json).get(HardwareBidJsonKeys.HARDWARE_OFFER_ID.getJsonKeyDescription());
        
        if (hardwareOfferId == null) {
            LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", HardwareBidJsonKeys.HARDWARE_OFFER_ID.getJsonKeyDescription());
            throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.",
                    HardwareBidJsonKeys.HARDWARE_OFFER_ID.getJsonKeyDescription()));        
        }
        return readJsonTree(json).get(HardwareBidJsonKeys.HARDWARE_OFFER_ID.getJsonKeyDescription()).asInt();
    }
    
    public int readBidderIdFromNode(String json) throws IOException {
        JsonNode bidderId = readJsonTree(json).get(HardwareBidJsonKeys.BIDDER_ID.getJsonKeyDescription());
        
        if (bidderId == null) {
            LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", HardwareBidJsonKeys.BIDDER_ID.getJsonKeyDescription());
            throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.",
                    HardwareBidJsonKeys.BIDDER_ID.getJsonKeyDescription()));        
        }
        return readJsonTree(json).get(HardwareBidJsonKeys.BIDDER_ID.getJsonKeyDescription()).asInt();
    }
    
    public String readEmailAddressFromNode(String json) throws IOException {              
        JsonNode emailAddress = readJsonTree(json).get(GamerJsonKeys.EMAIL_ADDRESS.getJsonKeyDescription());
        
        if (emailAddress == null) {
            LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", GamerJsonKeys.EMAIL_ADDRESS.getJsonKeyDescription());
            throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.",
                    GamerJsonKeys.EMAIL_ADDRESS.getJsonKeyDescription()));        
        }                
        
        return readJsonTree(json).get(GamerJsonKeys.EMAIL_ADDRESS.getJsonKeyDescription()).asText();                                                
    }
    
    public String readPasswordFromNode(String json) throws IOException {
        JsonNode passwordNode = readJsonTree(json).get(GamerJsonKeys.PASSWORD.getJsonKeyDescription());
        if (passwordNode == null) {
            LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", GamerJsonKeys.PASSWORD.getJsonKeyDescription());
            throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.",
                    GamerJsonKeys.PASSWORD.getJsonKeyDescription()));        
        }
        return readJsonTree(json).get(GamerJsonKeys.PASSWORD.getJsonKeyDescription()).asText();
    }
}
