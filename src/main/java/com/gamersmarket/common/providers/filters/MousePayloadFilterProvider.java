/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.providers.filters;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.utils.JsonUtilsMouse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import com.gamersmarket.common.annotations.jerseyfilters.ValidateMouseJsonPayload;
import java.io.InputStream;

/**
 *
 * @author cristiandrincu
 */
@ValidateMouseJsonPayload
public class MousePayloadFilterProvider implements ContainerRequestFilter {

    private static final Logger LOGGER = Logger.getLogger(MousePayloadFilterProvider.class.getName());       
    
    @Inject
    private JsonUtilsMouse jsonUtilsMouse;
    
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        if (isJson(request)) {
            String json = IOUtils.toString(request.getEntityStream(), Charsets.UTF_8);
            JsonNode mouseJsonNode = jsonUtilsMouse.readMouseFromNode(json);            
            
            if (jsonUtilsMouse.validateJsonKeys(mouseJsonNode)) {
                LOGGER.log(Level.INFO, "Mouse json keys are valid. Please check MouseJsonKeys enum for mouse payload json schema.");
                InputStream parsedJson = IOUtils.toInputStream(json);
                request.setEntityStream(parsedJson);
            }
        }
    }
    
    private boolean isJson(ContainerRequestContext request) {
        return request.getMediaType().toString().contains("application/json");
    }    
}
