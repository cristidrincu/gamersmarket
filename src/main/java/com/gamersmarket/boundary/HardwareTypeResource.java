package com.gamersmarket.boundary;

import com.gamersmarket.entity.types.HardwareType;
import com.gamersmarket.control.hardware.HardwareTypeRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/hardware-type")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HardwareTypeResource {

    @Inject
    HardwareTypeRepo hardwareTypeRepo;

    @GET
    @Path("{id}")
    public Response getHardwareType(@PathParam("id") int hardwareTypeId) {
        HardwareType hardwareTypeRetrieved = hardwareTypeRepo.getItem(hardwareTypeId);
        return Response.ok().entity(hardwareTypeRetrieved).build();
    }

    @POST
    public Response addHardwareType(HardwareType hardwareType) {
        hardwareTypeRepo.addItem(hardwareType);
        return Response.ok().entity("Hardware type created").build();
    }
}
