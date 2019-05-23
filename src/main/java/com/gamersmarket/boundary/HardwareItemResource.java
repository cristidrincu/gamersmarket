package com.gamersmarket.boundary;

import com.gamersmarket.common.enums.messages.HardwareItemMessages;
import com.gamersmarket.common.utils.customresponse.CustomHardwareItemBasicResponse;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.control.hardware.HardwareItemRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/hardware-item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HardwareItemResource {

    @Inject
    HardwareItemRepo hardwareItemRepo;
    
    @Inject
    CustomHardwareItemBasicResponse customHardwareItemBasicResponse;

    @GET
    public Response getHardwareItems() {
        return Response.ok().entity(hardwareItemRepo.getItems()).build();
    }
    
    @GET
    @Path("{id}")
    public Response getHardwareItem(@PathParam("id") int hardwareItemId) {
        HardwareItem retrievedHardwareItem = hardwareItemRepo.getItem(hardwareItemId);
        String responseMessage = HardwareItemMessages.HARDWARE_ITEM_RETRIEVED_SUCCESSFULLY.getMessage();
        return Response.ok()
                .entity(customHardwareItemBasicResponse.buildResponseHardwareItem(Response.Status.OK.getStatusCode(), responseMessage, retrievedHardwareItem))
                .build();
    }
}
