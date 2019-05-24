/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.providers.filters;

import com.gamersmarket.common.annotations.jerseyfilters.ValidateSecondaryFieldsForHardwareItem;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.exceptions.JsonParsingException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author cristiandrincu
 */
@ValidateSecondaryFieldsForHardwareItem
public class SecondaryFieldsHardwareItemFilterProvider implements ContainerRequestFilter {

    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());
    
    @Inject
    JsonUtils jsonUtils;
    
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        if (isJson(request)) {
            String json = IOUtils.toString(request.getEntityStream(), Charsets.UTF_8);
            int hwTypeId = jsonUtils.readHwTypeIdFromNode(json);
            int gamerId = jsonUtils.readGamerIdFromNode(json);
            
            if (hwTypeId < 0) {
                LOGGER.log(Level.WARNING, "The provided hardware type id has a negative value. Please fix this and try again!");
                throw new JsonParsingException(MessageFormat.format("The provided json key {0} is invalid.", "hwType->id"));
            }
            
            if (gamerId < 0) {
                LOGGER.log(Level.WARNING, "The provided gamer id has a negative value. Please fix this and try again!");
                throw new JsonParsingException(MessageFormat.format("The provided json key {0} is invalid.", "gamer->id"));
            }
        }
    }
    
    private boolean isJson(ContainerRequestContext request) {
        return request.getMediaType().toString().contains("application/json");
    }    
}
