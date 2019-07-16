/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.control.translation.MouseTranslationRepo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

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
    private MouseTranslationRepo mouseTranslationRepo;        
    
    @Inject
    private JsonUtils jsonUtils;
    
    @POST    
    public Response addMouseTranslation(String jsonTranslationNode) throws IOException {
        JsonNode rootNode = jsonUtils.readJsonTree(jsonTranslationNode);
        String languageFromJsonPayload = rootNode.get("language").asText();
        int mouseIdJsonPayload = rootNode.get("mouseId").asInt();
        mouseTranslationRepo.addTranslation(rootNode, languageFromJsonPayload, mouseIdJsonPayload);
        return Response.ok().entity("Hello").build();
    }
}
