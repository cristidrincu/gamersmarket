package com.gamersmarket.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.annotations.ValidateBasicCredentials;
import com.gamersmarket.common.enums.jsonkeys.GamerJsonKeys;
import com.gamersmarket.common.enums.messages.AccountManagementMessages;
import com.gamersmarket.common.interfaces.KeyGenerator;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.utils.AccountManagement;
import com.gamersmarket.common.utils.Authentication;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.customresponse.CustomGamerBasicResponse;
import com.gamersmarket.control.gamers.GamerProfileDTO;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Stateless
@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountManagementResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    private Authentication auth;

    @Inject
    private GamersRepo gamersRepo;

    @Inject
    private AccountManagement accountManagement;

    @Inject
    private CustomGamerBasicResponse basicResponse;

    @Inject
    private JsonUtils jsonUtils;

    @Inject
    private KeyGenerator keyGenerator;

    @POST
    @Path("/create-account/gamer")
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
        Map<String, Object> jsonResponse = new HashMap<>();

        if (auth.authenticateUser(gamer, password)) {
            ObjectMapperProvider mapper = jsonUtils.getProvider();

            String token = issueToken(emailAddress);
            GamerProfileDTO gamerProfileDTO = new GamerProfileDTO(gamer);

            jsonResponse.put("authenticationToken", token);
            jsonResponse.put("gamer", gamerProfileDTO);

            return Response.ok()
                    .header(AUTHORIZATION, "Bearer: " + token)
                    .entity(mapper.getObjectMapper().writeValueAsString(jsonResponse))
                    .build();
        } else {
            return Response.status(UNAUTHORIZED).build();
        }
    }

    private String issueToken(String emailAddress) {
        Key key = keyGenerator.generateKey();
        return Jwts.builder()
                .setSubject(emailAddress)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
