package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.messages.HardwareOfferMessages;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.CustomBasicResponse;
import com.gamersmarket.control.hardware.HardwareOfferRepo;
import com.gamersmarket.entity.hardware.HardwareOffer;
import java.io.IOException;
import java.util.List;

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
    CustomBasicResponse basicResponse;

    @Inject
    HardwareOfferRepo hardwareOfferRepo;
    
    @Inject
    ObjectMapperProvider provider;

    @GET
    public Response getHardwareOffers() {        
        String responseMessageDescription = HardwareOfferMessages.FETCH_ALL_HARDWARE_OFFERS.getMessageDescription();
        List<HardwareOffer> hwOffers = hardwareOfferRepo.getItems();                
        return Response.ok().entity(basicResponse.buildResponseHardwareOffers(Response.Status.OK.getStatusCode(), responseMessageDescription, hwOffers)).build();
    }
    
    @GET
    @Path("/state")
    public Response getHardwareOffersBasedOnState(@QueryParam("state") String hwOfferState) {
        return Response.ok().entity(hardwareOfferRepo.getHardwareOffersBasedOnState(hwOfferState)).build();
    }

    @POST
    @Path("/initial-offer")
    public Response addInitialHardwareOffer(String jsonObject) throws IOException {
        JsonNode rootNode = provider.getContext(HardwareOfferResource.class).readTree(jsonObject);
        JsonNode hwPricingNode = rootNode.get("hwPricing");               
        String responseMessageDescription = HardwareOfferMessages.INITIAL_HARDWARE_OFFER_SUCCESS_MESSAGE.getMessageDescription();

        hardwareOfferRepo.buildInitialHardwareOffer(rootNode, hwPricingNode);
        return Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(), responseMessageDescription)).build();
    }

    @POST
    @Path("/final-offer")
    public Response addFinalHardwareOffer(String jsonObject) throws IOException {        
        JsonNode rootNode = provider.getContext(HardwareOfferResource.class).readTree(jsonObject);
        String responseMessageDescription = HardwareOfferMessages.FINAL_HARDWARE_OFFER_SUCCESS_MESSAGE.getMessageDescription();
        
        hardwareOfferRepo.buildFinalHardwareOffer(rootNode);
        return Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(), responseMessageDescription)).build();
    }
}
