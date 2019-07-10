package com.gamersmarket.boundary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.annotations.ValidateMouseJsonPayload;
import com.gamersmarket.common.enums.jsonkeys.MouseJsonKeys;
import com.gamersmarket.common.enums.messages.HardwareItemMessages;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.customresponse.CustomHardwareItemBasicResponse;
import com.gamersmarket.control.hardware.MouseRepo;
import com.gamersmarket.control.hardware.dto.MouseDetailsDTO;
import com.gamersmarket.entity.hardware.Mouse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Stateless
@Path("/gaming-mouse")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MouseResource {

    @Inject
    private MouseRepo mouseRepo;    

    @Inject
    private MouseDetailsDTO mouseDetailsDTO;        
    
    @Inject
    private CustomHardwareItemBasicResponse basicResponse;
    
    @Inject
    private JsonUtils jsonUtils;        

    @GET
    public Response getMice() {
//        return Response.ok().entity(mouseDetailsDTO.buildMiceList()).build();
        return Response.ok().entity("here a mouse list lives").build();
    }
    
    @GET
    @Path("/{language}/{id}/basic-details")
    public Response getMouseDetails(@PathParam("language") String language, @PathParam("id") int id) throws JsonProcessingException {
        return Response.ok().entity(mouseDetailsDTO.buildMouseDetails(language, id, jsonUtils)).build();
    }

    @GET
    @Path("{id}/complete-details")
    public Response getCompleteMouseDetails(@PathParam("id") int id) throws JsonProcessingException {
//        TODO - implement business logic for complete mouse details
        return Response.ok().entity("Hello from complete details for mouse").build();
    }

    @POST
    @ValidateMouseJsonPayload
    public Response addMouse(String jsonObject) throws IOException {        
        JsonNode rootNode = jsonUtils.readJsonTree(jsonObject);
        
        Mouse mouse = new Mouse(rootNode.get(MouseJsonKeys.ROOT_NODE.getJsonKeyDescription()));        
        int hwTypeId = jsonUtils.readHwTypeIdFromNode(jsonObject);
        int gamerId = jsonUtils.readGamerIdFromNode(jsonObject);

        mouseRepo.persistItemWithHardwareType(mouse, hwTypeId, gamerId);
        return Response.ok().entity(basicResponse.buildResponseHardwareItem(Response.Status.OK.getStatusCode(), 
            HardwareItemMessages.HARDWARE_ITEM_CREATED_SUCCESSFULLY.getMessage(), mouse)).build();
        }
        
    @DELETE
    @Path("/remove/{id}")
    public Response deleteMouse(@PathParam("id") String mouseId) {
        mouseRepo.deleteItem(Integer.parseInt(mouseId));
        return Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(),
                HardwareItemMessages.HARDWARE_ITEM_DELETED_SUCCESSFULLY.getMessage())).build();
    }
}
