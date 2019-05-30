/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.jsonkeys.MouseJsonKeys;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.exceptions.json.JsonParsingException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author cristiandrincu
 */
public class JsonUtilsMouse {
    
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());
    
    @Inject
    private ObjectMapperProvider provider;        
    
    @Inject
    public JsonUtilsMouse() {}
    
    public JsonNode readMouseFromNode(String json) throws IOException {
        JsonNode mouseNode = provider.getContext(JsonUtilsMouse.class).readTree(json).get(MouseJsonKeys.ROOT_NODE.getJsonKeyDescription());
        if (mouseNode == null) {
            LOGGER.log(Level.SEVERE, "Json key {0} is missing. Please check json body.", MouseJsonKeys.ROOT_NODE.getJsonKeyDescription());
            throw new JsonParsingException(MessageFormat.format("Json key {0} does not exist or is mistyped. Please check the json body on your request.", 
                    MouseJsonKeys.ROOT_NODE.getJsonKeyDescription()));        
        }
        
        return mouseNode;
    }
    
    public boolean validateJsonKeysMousePayload(JsonNode mouseJsonNode) throws IOException {              
        HashSet<String> mouseJsonKeysEnumValues = MouseJsonKeys.getMouseKeyConstantsAsSet();                          
        Iterator<Map.Entry<String, JsonNode>> mouseNodes = mouseJsonNode.fields();        
        while(mouseNodes.hasNext()) {                        
            if (!mouseJsonKeysEnumValues.contains(mouseNodes.next().getKey())) {                
                LOGGER.log(Level.SEVERE, "Invalid json payload.");
                throw new JsonParsingException("Invalid json payload.");
            }
        }
        
        return true;
    }        
}
