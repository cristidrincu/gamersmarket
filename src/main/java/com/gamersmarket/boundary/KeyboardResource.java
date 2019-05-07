/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.BasicResponse;
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
    KeyboardRepo keyboardRepo;
    
    @Inject
    ObjectMapperProvider provider;
    
    @Inject
    BasicResponse basicResponse;
    
    @GET
    public Response getKeyboards() {
        return Response.ok().build();
    }
    
    @GET
    @Path("{id}/basic-details")
    public Response getKeyboardBasicDetails(@PathParam("id") int id) {
        Keyboard keyboard = keyboardRepo.getItem(id);
        return Response.ok(basicResponse.buildResponse(200, "Keyboard basic details fetched successfully!", keyboard)).build();
    }
    
    @POST
    public Response addKeyboard(String jsonObject) throws IOException {
        JsonNode rootNode = provider.getContext(KeyboardResource.class).readTree(jsonObject);
        Keyboard keyboard = new Keyboard(rootNode.get("keyboard"));
        int hwTypeId = rootNode.get("hwType").get("id").asInt();
        
        keyboardRepo.persistItemWithHardwareType(keyboard, hwTypeId);        
        
        return Response.ok().entity(basicResponse.buildResponse(200, "Keyboard saved successfully!", keyboard)).build();
    }
}
