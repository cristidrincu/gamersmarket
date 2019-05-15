package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.messages.AccountManagementMessages;
import com.gamersmarket.common.enums.jsonkeys.GamerJsonKeys;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.AccountManagement;
import com.gamersmarket.common.utils.Authentication;
import com.gamersmarket.common.utils.CustomBasicResponse;
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
    GamersRepo gamersRepo;
    
    @Inject
    Authentication auth;
    
    @Inject
    AccountManagement accountManagement;

    @Inject
    ObjectMapperProvider provider;
    
    @Inject
    CustomBasicResponse basicResponse;

    @GET
    @Path("{id}")
    public Response getGamerDetails(@PathParam("id") int gamerId) {
        return Response.ok().entity(gamersRepo.getGamerDetails(gamerId)).build();
    }

    @POST
    public Response createGamerAccount(String jsonGamerAccount) throws IOException {
        JsonNode rootNode = readTreeJsonGamerAccount(jsonGamerAccount);  
        String responseMessageSuccess = AccountManagementMessages.ACCOUNT_CREATED_SUCCESSFULLY.getMessageDescription();
        Gamer gamer = new Gamer(rootNode.get(GamerJsonKeys.ROOT_NODE.getJsonKeyDescription()));
        accountManagement.createAccount(gamer);
        
        return Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(), responseMessageSuccess)).build();
    }
    
    @POST
    @Path("/authenticate")
    public Response authenticateGamer(String jsonGamerAccount) throws IOException {
        JsonNode rootNode = readTreeJsonGamerAccount(jsonGamerAccount);                
        String emailAddress = rootNode.get(GamerJsonKeys.EMAIL_ADDRESS.getJsonKeyDescription()).asText();
        String password = rootNode.get(GamerJsonKeys.PASSWORD.getJsonKeyDescription()).asText();        
        Gamer gamer = gamersRepo.getGamerDetails(emailAddress);        
        
        String responeMessageSuccess = AccountManagementMessages.ACCOUNT_FETCHED_SUCCESSFULLY.getMessageDescription();
        String responseMessageError = AccountManagementMessages.WRONG_CREDENTIALS.getMessageDescription();
        
        return auth.authenticateUser(gamer, password) ?
                Response.ok().entity(basicResponse.buildResponseGamer(Response.Status.OK.getStatusCode(), responeMessageSuccess, gamer)).build() : 
                Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.BAD_REQUEST.getStatusCode(), responseMessageError)).build();        
    }
    
    @DELETE
    @Path("/delete-account/{gamerId}")
    public Response deleteGamerAccount(@PathParam("gamerId") String gamerId) throws IOException {
        Gamer gamer = gamersRepo.getGamerDetails(parseInt(gamerId));
        String responseMessage = AccountManagementMessages.ACCOUNT_DELETED_SUCCESSFULLY.getMessageDescription();
        gamersRepo.deleteGamer(gamer.getId());
        return Response.ok().entity(basicResponse.buildDefaultResponse(Response.Status.OK.getStatusCode(), responseMessage)).build();
    }
    
    private JsonNode readTreeJsonGamerAccount(String jsonGamerAccount) throws IOException {
        return provider.getContext(GamersResource.class).readTree(jsonGamerAccount);
    }
}
