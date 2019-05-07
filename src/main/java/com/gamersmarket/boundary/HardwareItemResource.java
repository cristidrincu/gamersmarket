package com.gamersmarket.boundary;

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

    @GET
    public Response getHardwareItems() {
        return Response.ok().entity(hardwareItemRepo.getItems()).build();
    }
    
    @GET
    @Path("{id}")
    public Response getHardwareItem(@PathParam("id") int hardwareItemId) {
        HardwareItem retrievedHardwareItem = hardwareItemRepo.getItem(hardwareItemId);
        return Response.ok().entity(retrievedHardwareItem).build();
    }
}
