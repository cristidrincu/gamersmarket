/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.control.language.LanguageRepo;
import com.gamersmarket.entity.language.Language;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("/languages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LanguageResource {
    
    @Inject
    private LanguageRepo languageRepo;
    
    @Inject
    private JsonUtils jsonUtils;
    
    @GET
    public Response getLanguages() {
        return Response.ok().entity("Hello from languages endpoint.").build();
    }
    
    @POST
    public Response addLanguage(String jsonNodeLanguage) throws IOException {
        JsonNode rootNode = jsonUtils.readJsonTree(jsonNodeLanguage);
        Language language = new Language(rootNode);
        languageRepo.addLanguage(language);
        return Response.ok().entity(language).build();
    }
}
