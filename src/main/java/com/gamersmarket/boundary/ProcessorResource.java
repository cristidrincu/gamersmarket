/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.messages.HardwareItemMessages;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.customresponse.CustomHardwareItemBasicResponse;
import com.gamersmarket.control.hardware.ProcessorRepo;
import com.gamersmarket.entity.hardware.Processor;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author cristiandrincu
 */
@Stateless
@Path("/processors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcessorResource {
 
    @Inject
    private ProcessorRepo processorRepo;        
    
    @Inject
    private JsonUtils jsonUtils;
    
    @Inject
    private CustomHardwareItemBasicResponse basicReponse;
    
    @GET
    public Response getProcessors() {
        return Response.ok().entity("Hello from processors endpoint").build();
    }
    
    @POST    
    public Response addProcessor(String jsonObject) throws IOException {
        JsonNode rootNode = jsonUtils.readJsonTree(jsonObject);
        
        Processor processor = new Processor(rootNode.get("processor"));        
        int hwTypeId = jsonUtils.readHwTypeIdFromNode(jsonObject);
        int gamerId = jsonUtils.readGamerIdFromNode(jsonObject);
        
        processorRepo.persistItemWithHardwareType(processor, hwTypeId, gamerId);
        
        return Response.ok().entity(basicReponse.buildResponseHardwareItem(Response.Status.OK.getStatusCode(),
                HardwareItemMessages.HARDWARE_ITEM_CREATED_SUCCESSFULLY.getMessage(), processor)).build();
    }
}
