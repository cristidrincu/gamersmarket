package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.enums.GamerJsonKeys;
import com.gamersmarket.common.providers.ObjectMapperProvider;
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
    ObjectMapperProvider provider;        

    @GET
    @Path("{id}")
    public Response getGamerDetails(@PathParam("id") int gamerId) {
        return Response.ok().entity(gamersRepo.getGamerDetails(gamerId)).build();
    }

    @POST
    public Response createGamerAccount(String jsonGamerAccount) throws IOException {
        JsonNode rootNode = provider.getContext(GamersResource.class).readTree(jsonGamerAccount);
        
        Gamer gamer = new Gamer(rootNode.get(GamerJsonKeys.ROOT_NODE.getJsonKeyDescription()));
        gamersRepo.createAccount(gamer);
        return Response.ok().entity("Account created successfully").build();
    }
}
