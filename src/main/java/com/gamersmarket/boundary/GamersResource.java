package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.annotations.jerseyfilters.ValidateBasicCredentials;
import com.gamersmarket.common.enums.messages.AccountManagementMessages;
import com.gamersmarket.common.enums.jsonkeys.GamerJsonKeys;
import com.gamersmarket.common.utils.AccountManagement;
import com.gamersmarket.common.utils.Authentication;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.customresponse.CustomGamerBasicResponse;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import static java.lang.Integer.parseInt;

@Stateless
@Path("/gamers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GamersResource {

    @Inject
    private GamersRepo gamersRepo;
    
    @Inject
    private Authentication auth;
    
    @Inject
    private AccountManagement accountManagement;   
    
    @Inject
    private CustomGamerBasicResponse basicResponse;
    
    @Inject
    private JsonUtils jsonUtils;

    @GET
    @Path("{id}")
    public Response getGamerDetails(@PathParam("id") int gamerId) {
        return Response.ok().entity(gamersRepo.getGamerDetails(gamerId)).build();
    }

    @POST
    public Response createGamerAccount(String jsonGamerAccount) throws IOException {
        JsonNode rootNode = jsonUtils.readJsonTree(jsonGamerAccount);  
        String responseMessageSuccess = AccountManagementMessages.ACCOUNT_CREATED_SUCCESSFULLY.getMessageDescription();
        Gamer gamer = new Gamer(rootNode.get(GamerJsonKeys.ROOT_NODE.getJsonKeyDescription()));
        accountManagement.createAccount(gamer);
        
        return Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(), responseMessageSuccess)).build();
    }
    
    @POST
    @ValidateBasicCredentials
    @Path("/authenticate")
    public Response authenticateGamer(String jsonGamerAccount) throws IOException {                       
        String emailAddress = jsonUtils.readEmailAddressFromNode(jsonGamerAccount);
        String password = jsonUtils.readPasswordFromNode(jsonGamerAccount);
        Gamer gamer = gamersRepo.getGamerDetails(emailAddress);
        
        String responeMessageSuccess = AccountManagementMessages.ACCOUNT_FETCHED_SUCCESSFULLY.getMessageDescription();
        String responseMessageError = AccountManagementMessages.WRONG_CREDENTIALS.getMessageDescription();
        
        return auth.authenticateUser(gamer, password) ?
                Response.ok().entity(basicResponse.buildResponseGamer(Response.Status.OK.getStatusCode(), responeMessageSuccess, gamer)).build() : 
                Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.BAD_REQUEST.getStatusCode(), responseMessageError)).build();        
    }
    
    @DELETE
    @Path("/delete-account/{id}")
    public Response deleteGamerAccount(@PathParam("id") int gamerId) throws IOException {
        Gamer gamer = gamersRepo.getGamerDetails(gamerId);
        String responseMessage = AccountManagementMessages.ACCOUNT_DELETED_SUCCESSFULLY.getMessageDescription();
        gamersRepo.deleteGamer(gamer.getId());
        return Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(), responseMessage)).build();
    }    
}
