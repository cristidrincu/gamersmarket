package com.gamersmarket.boundary;

import com.gamersmarket.control.manufacturer.ManufacturerRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Stateless
@Path("/hardware-mfs")
public class ManufacturerResource {

    @Inject
    ManufacturerRepo manufacturerRepo;

    @GET
    public Response getAll() {
        return Response.ok().entity(manufacturerRepo.getAll()).build();
    }
}
