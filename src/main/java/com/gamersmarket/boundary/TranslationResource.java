/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.boundary;

import com.gamersmarket.common.interfaces.TranslationRepository;
import com.gamersmarket.common.utils.JsonUtils;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author cristiandrincu
 */
@Stateless
@Path("/translations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TranslationResource {
      
    @Inject
    private TranslationRepository translationRepository;
    
    @Inject
    private JsonUtils jsonUtils;
    
    @POST
    @Path("/mouse")
    public Response addMouseTranslation(String jsonMouseTranslationNode) {
        return Response.ok().entity("Hello").build();
    }
}
