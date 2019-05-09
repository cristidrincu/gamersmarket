package com.gamersmarket.boundary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.jsonkeys.MouseJsonKeys;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.BasicResponse;
import com.gamersmarket.control.hardware.dto.MouseDetailsDTO;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.control.hardware.MouseRepo;
import com.gamersmarket.common.utils.template.hardware.MouseTemplate;

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
    MouseRepo mouseRepo;

    @Inject
    MouseTemplate getMouseTemplate;

    @Inject
    MouseDetailsDTO mouseDetailsDTO;
    
    @Inject
    ObjectMapperProvider provider;
    
    @Inject
    BasicResponse basicResponse;

    @GET
    public Response getMice() {
        return Response.ok().entity(mouseDetailsDTO.buildMiceList()).build();
    }
    
    @GET
    @Path("{id}/basic-details")
    public Response getMouseDetails(@PathParam("id") int id) throws JsonProcessingException {
        return Response.ok().entity(mouseDetailsDTO.buildMouseDetails(id)).build();
    }

    @GET
    @Path("{id}/complete-details")
    public Response getCompleteMouseDetails(@PathParam("id") int id) throws JsonProcessingException {
//        TODO - implement business logic for complete mouse details
        return Response.ok().entity("Hello from complete details for mouse").build();
    }

    @POST
    public Response addMouse(String jsonObject) throws IOException {        
        JsonNode rootNode = provider.getContext(MouseResource.class).readTree(jsonObject);
        
        Mouse mouse = new Mouse(rootNode.get(MouseJsonKeys.ROOT_NODE.getJsonKeyDescription()));        
        int hwTypeId = rootNode.get("hwType").get("id").asInt();
        
        mouseRepo.persistItemWithHardwareType(mouse, hwTypeId);
        return Response.ok().entity("Mouse saved successfully").build();
    }
    
    @DELETE
    @Path("/remove/{id}")
    public Response deleteMouse(@PathParam("id") String mouseId) {
        mouseRepo.deleteItem(Integer.parseInt(mouseId));
        return Response.ok().entity("Mouse deleted successfully!").build();
    }
}
