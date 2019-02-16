package com.gamersmarket.boundary;

import com.gamersmarket.entity.hardware.GraphicsCard;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.control.hardware.GraphicsCardRepo;
import com.gamersmarket.utils.template.GetGraphicsCardTemplate;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Stateless
@Path("/graphic-cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GraphicCardResource {

    @Inject
    GraphicsCardRepo graphicsCardRepo;

    @Inject
    GetGraphicsCardTemplate graphicsCardTemplate;

    @GET
    @Path("{id}")
    public Response getGraphicsCardDetails(@PathParam("id") int graphicsCardId) {
        GraphicsCard retrievedGraphicsCard = graphicsCardRepo.getItem(graphicsCardId);
        return Response.ok().entity(retrievedGraphicsCard).build();
    }

    @POST
    public Response addGraphicCard(String jsonObject) throws IOException {
        GraphicsCard graphicsCard = graphicsCardTemplate.getSpecificHardwareItem(jsonObject);
        HardwareItem hwItem = graphicsCardTemplate.getHardwareItem(jsonObject);
        int hwTypeId = graphicsCardTemplate.getHardwareTypeId(jsonObject);

        graphicsCardRepo.persistItemWithHardwareType(graphicsCard, hwItem, hwTypeId);

        return Response.ok().entity("Graphics card saved successfully.").build();
    }
}
