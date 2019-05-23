/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
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
}
