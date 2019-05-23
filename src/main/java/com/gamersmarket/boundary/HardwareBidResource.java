/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.jsonkeys.HardwareBidJsonKeys;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.customresponse.CustomBasicResponse;
import com.gamersmarket.control.bidding.HardwareBidRepo;
import com.gamersmarket.entity.bid.HardwareBid;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author cristiandrincu
 */
@Stateless
@Path("/hardware-bid")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HardwareBidResource {
    
    @Inject
    HardwareBidRepo hardwareBidRepo;        
    
    @Inject
    ObjectMapperProvider provider;
    
    @Inject
    CustomBasicResponse basicResponse;
    
    @Inject
    JsonUtils jsonUtils;
    
    @GET
    @Path("{userId}/{hardwareBidId}")
    public Response getHardwareBidsForGamer(@PathParam("userId") String userId, @PathParam("hardwareBidId") String hardwareBidId) {
        return Response.ok().entity("Hello from hardware bid").build();
    }
    
    @POST
    public Response placeHardwareBid(String jsonHardwareBid) throws IOException {
       JsonNode rootNode = provider.getContext(HardwareBidResource.class).readTree(jsonHardwareBid);
       int hardwareOfferId = jsonUtils.readHardwareOfferIdFromNode(jsonHardwareBid);
       int bidderId = jsonUtils.readBidderIdFromNode(jsonHardwareBid);
              
       HardwareBid hardwareBid = hardwareBidRepo.addBid(rootNode, hardwareOfferId, bidderId);
       return Response.ok()
               .entity(basicResponse.buildHardwareOfferBid(Response.Status.OK.getStatusCode(), "Hardware bid placed successfully.", hardwareBid))
               .build();
    }
    
    @DELETE
    @Path("{id}")
    public Response deleteHardwareBid(@PathParam("id") String hardwareBidId) {        
        hardwareBidRepo.deleteBid(parseInt(hardwareBidId));
        return Response.ok()
                .entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(), "Hardware bid deleted successfully."))
                .build();
    }
}
