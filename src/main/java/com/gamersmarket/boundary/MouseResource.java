package com.gamersmarket.boundary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gamersmarket.control.hardware.dto.MouseDetailsDTO;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.control.hardware.MouseRepo;
import com.gamersmarket.common.utils.template.GetMouseTemplate;

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
    GetMouseTemplate getMouseTemplate;

    @Inject
    MouseDetailsDTO mouseDetailsDTO;

    @GET
    @Path("{id}")
    public Response getMouseDetails(@PathParam("id") int id) throws JsonProcessingException {
        return Response.ok().entity(mouseDetailsDTO.buildMouseDetails(id)).build();
    }

    @POST
    public Response addMouse(String jsonObject) throws IOException {
        Mouse mouse = getMouseTemplate.getSpecificHardwareItem(jsonObject);
        HardwareItem hwItem = getMouseTemplate.getHardwareItem(jsonObject);
        int hwTypeId = getMouseTemplate.getHardwareTypeId(jsonObject);

        mouseRepo.persistItemWithHardwareType(mouse, hwItem, hwTypeId);
        return Response.ok().entity("Mouse saved successfully").build();
    }
}
