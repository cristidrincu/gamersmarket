/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.jsonkeys.KeyboardJsonKeys;
import com.gamersmarket.common.enums.messages.HardwareItemMessages;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.customresponse.CustomHardwareItemBasicResponse;
import com.gamersmarket.control.hardware.KeyboardRepo;
import com.gamersmarket.entity.hardware.Keyboard;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.gamersmarket.common.annotations.jerseyfilters.ValidateMouseJsonPayload;

/**
 *
 * @author cristiandrincu
 */
@Stateless
@Path("/keyboards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KeyboardResource {
    
    @Inject
    private KeyboardRepo keyboardRepo;
    
    @Inject
    private JsonUtils jsonUtils;
    
    @Inject
    private CustomHardwareItemBasicResponse basicResponse;
    
    @GET
    public Response getKeyboards() {
        return Response.ok().build();
    }
    
    @GET
    @Path("{id}/basic-details")
    public Response getKeyboardBasicDetails(@PathParam("id") int id) {
        Keyboard keyboard = keyboardRepo.getItem(id);
        return Response.ok(basicResponse.buildResponseHardwareItem(Response.Status.OK.getStatusCode(),
                HardwareItemMessages.HARDWARE_ITEM_RETRIEVED_SUCCESSFULLY.getMessage(), keyboard)).build();
    }
    
    @POST
    @ValidateMouseJsonPayload
    public Response addKeyboard(String jsonObject) throws IOException {
        JsonNode rootNode = jsonUtils.readJsonTree(jsonObject);
        Keyboard keyboard = new Keyboard(rootNode.get(KeyboardJsonKeys.ROOT_NODE.getJsonKeyDescription()));
        
        int hwTypeId = jsonUtils.readHwTypeIdFromNode(jsonObject);
        int gamerId = jsonUtils.readGamerIdFromNode(jsonObject);
        
        keyboardRepo.persistItemWithHardwareType(keyboard, hwTypeId, gamerId);        
        
        return Response.ok().entity(basicResponse.buildResponseHardwareItem(Response.Status.OK.getStatusCode(), 
                HardwareItemMessages.HARDWARE_ITEM_CREATED_SUCCESSFULLY.getMessage(), keyboard)).build();
    }
}
