package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.messages.AccountManagementMessages;
import com.gamersmarket.common.enums.jsonkeys.GamerJsonKeys;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.AccountManagement;
import com.gamersmarket.common.utils.Authentication;
import com.gamersmarket.common.utils.BasicResponse;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

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
    BasicResponse basicResponse;

    @GET
    @Path("{id}")
    public Response getGamerDetails(@PathParam("id") int gamerId) {
        return Response.ok().entity(gamersRepo.getGamerDetails(gamerId)).build();
    }

    @POST
    public Response createGamerAccount(String jsonGamerAccount) throws IOException {
        JsonNode rootNode = readTreeJsonGamerAccount(jsonGamerAccount);        
        Gamer gamer = new Gamer(rootNode.get(GamerJsonKeys.ROOT_NODE.getJsonKeyDescription()));
        accountManagement.createAccount(gamer);
        
        return Response.ok()
                .entity(basicResponse.buildResponse(Response.Status.OK.getStatusCode(),
                        AccountManagementMessages.ACCOUNT_CREATED_SUCCESSFULLY.getMessageDescription()))
                .build();
    }
    
    @POST
    @Path("/authenticate")
    public Response authenticateGamer(String jsonGamerAccount) throws IOException {
        JsonNode rootNode = readTreeJsonGamerAccount(jsonGamerAccount);        
        String emailAddress = rootNode.get(GamerJsonKeys.EMAIL_ADDRESS.getJsonKeyDescription()).asText();
        String password = rootNode.get(GamerJsonKeys.PASSWORD.getJsonKeyDescription()).asText();        
        Gamer gamer = gamersRepo.getGamerDetails(emailAddress);        
        
        return auth.authenticateUser(gamer, password) ?
                Response.ok()
                        .entity(gamer)
                        .build() : 
                Response.ok()
                        .entity(basicResponse.buildResponse(Response.Status.BAD_REQUEST.getStatusCode(), 
                                AccountManagementMessages.WRONG_CREDENTIALS.getMessageDescription()))
                        .build();        
    }
    
    private JsonNode readTreeJsonGamerAccount(String jsonGamerAccount) throws IOException {
        return provider.getContext(GamersResource.class).readTree(jsonGamerAccount);
    }
}
