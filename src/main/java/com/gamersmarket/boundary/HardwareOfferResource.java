package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.utils.BasicResponse;
import com.gamersmarket.control.hardware.HardwareOfferRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/hardware-offers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HardwareOfferResource {

    @Inject
    BasicResponse basicResponse;

    @Inject
    HardwareOfferRepo hardwareOfferRepo;

    @GET
    public Response getHardwareOffers() {
        return Response.ok().entity("Hello from hardware offers endpoint").build();
    }

    @POST
    @Path("/initial-offer")
    public Response addInitialHardwareOffer(JsonNode hardwareOfferJson) {
        hardwareOfferRepo.buildInitialHardwareOffer(hardwareOfferJson);
        return Response.ok()
                .entity(basicResponse.buildResponse(Response.Status.OK.getStatusCode(), "Initial hardware offer created successfully")).build();
    }

    @POST
    @Path("/final-offer")
    public Response addFinalHardwareOffer(JsonNode hardwareOfferJson) {
        //TODO - when adding a hardware item, we need to add the minPrice, maxPrice etc to the json and create a new hardware item price - otherwise eclipse link complains
        hardwareOfferRepo.buildFinalHardwareOffer(hardwareOfferJson);

        return Response.ok()
                .entity(basicResponse.buildResponse(Response.Status.OK.getStatusCode(), "Final hardware offer created successfully")).build();
    }
}
