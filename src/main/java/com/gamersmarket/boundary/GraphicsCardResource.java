package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.messages.HardwareItemMessages;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.customresponse.CustomHardwareItemBasicResponse;
import com.gamersmarket.entity.hardware.GraphicsCard;
import com.gamersmarket.control.hardware.GraphicsCardRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Stateless
@Path("/graphic-cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GraphicsCardResource {

    @Inject
    private GraphicsCardRepo graphicsCardRepo; 
    
    @Inject
    private CustomHardwareItemBasicResponse basicResponse;
    
    @Inject
    private JsonUtils jsonUtils;

    @GET
    @Path("{id}")
    public Response getGraphicsCardDetails(@PathParam("id") int graphicsCardId) {
        GraphicsCard retrievedGraphicsCard = graphicsCardRepo.getItem(graphicsCardId);
        return Response.ok().entity(retrievedGraphicsCard).build();
    }

    @POST    
    public Response addGraphicCard(String jsonObject) throws IOException {
        JsonNode rootNode = jsonUtils.readJsonTree(jsonObject);
        
        GraphicsCard graphicsCard = new GraphicsCard(rootNode.get("graphicsCard"));        
        int hwTypeId = jsonUtils.readHwTypeIdFromNode(jsonObject);
        int gamerId = jsonUtils.readGamerIdFromNode(jsonObject);

        graphicsCardRepo.persistItemWithHardwareType(graphicsCard, hwTypeId, gamerId);

        return Response.ok().entity(basicResponse.buildResponseHardwareItem(Response.Status.OK.getStatusCode(), 
                HardwareItemMessages.HARDWARE_ITEM_CREATED_SUCCESSFULLY.getMessage(), graphicsCard)).build();
    }
}
