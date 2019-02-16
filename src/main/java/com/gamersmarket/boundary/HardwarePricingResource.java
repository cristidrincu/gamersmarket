package com.gamersmarket.boundary;

import com.gamersmarket.entity.pricing.HardwarePricing;
import com.gamersmarket.control.pricing.HardwarePricingRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/hardware-items-pricing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HardwarePricingResource {

    @Inject
    HardwarePricingRepo hardwarePricingRepo;

    @POST
    public Response addHardwarePrice(HardwarePricing hardwarePricing) {
        hardwarePricingRepo.addPricing(hardwarePricing);
        return Response.ok().entity("Hello from hw item pricing").build();
    }

    @Path("/hardware-type/{hardware-type-id}")
    @POST
    public Response addHardwarePricingToHardwareType(HardwarePricing hardwarePricing, @PathParam("hardware-type-id") int id) {
        hardwarePricingRepo.addPricingToHardwareType(hardwarePricing, id);
        return Response.ok().entity("Pricing added successfully").build();
    }
}
