package com.gamersmarket.boundary;

import com.gamersmarket.common.annotations.JWTTokenNeeded;
import com.gamersmarket.common.enums.messages.AccountManagementMessages;
import com.gamersmarket.common.utils.customresponse.CustomGamerBasicResponse;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/gamers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GamersResource {

    @Inject
    private GamersRepo gamersRepo;
    
    @Inject
    private CustomGamerBasicResponse basicResponse;

    @GET
    @Path("{id}")
    @JWTTokenNeeded
    public Response getGamerDetails(@PathParam("id") int gamerId) {
        return Response.ok().entity(gamersRepo.getGamerDetails(gamerId)).build();
    }
    
    @DELETE
    @Path("/delete-account/{id}")
    public Response deleteGamerAccount(@PathParam("id") int gamerId) {
        Gamer gamer = gamersRepo.getGamerDetails(gamerId);
        String responseMessage = AccountManagementMessages.ACCOUNT_DELETED_SUCCESSFULLY.getMessageDescription();
        gamersRepo.deleteGamer(gamer.getId());
        return Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(), responseMessage)).build();
    }    
}
