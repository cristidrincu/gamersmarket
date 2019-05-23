/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.jsonkeys.GamerJsonKeys;
import com.gamersmarket.common.enums.jsonkeys.HardwareBidJsonKeys;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import java.io.IOException;
import javax.inject.Inject;

/**
 *
 * @author cristiandrincu
 */
public class JsonUtils {
    
    @Inject
    ObjectMapperProvider provider;
    
    @Inject
    public JsonUtils() {}
    
    public JsonNode readJsonTree(String json) throws IOException {
        return provider.getContext(JsonUtils.class).readTree(json);
    }
    
    public int readHwTypeIdFromNode(String json) throws IOException {
        return readJsonTree(json).get("hwType").get("id").asInt();
    }
    
    public int readGamerIdFromNode(String json) throws IOException {
        return readJsonTree(json).get("gamer").get("id").asInt();
    }
    
    public int readHardwareOfferIdFromNode(String json) throws IOException {
        return readJsonTree(json).get(HardwareBidJsonKeys.HARDWARE_OFFER_ID.getJsonKeyDescription()).asInt();
    }
    
    public int readBidderIdFromNode(String json) throws IOException {
        return readJsonTree(json).get(HardwareBidJsonKeys.BIDDER_ID.getJsonKeyDescription()).asInt();
    }
    
    public String readEmailAddressFromNode(String json) throws IOException {
        return readJsonTree(json).get(GamerJsonKeys.EMAIL_ADDRESS.getJsonKeyDescription()).asText();
    }
    
    public String readPasswordFromNode(String json) throws IOException {
        return readJsonTree(json).get(GamerJsonKeys.PASSWORD.getJsonKeyDescription()).asText();
    }
}
