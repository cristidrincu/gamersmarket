package com.gamersmarket.common.providers.filters;

import com.gamersmarket.common.annotations.JWTTokenNeeded;
import com.gamersmarket.common.interfaces.KeyGenerator;
import io.jsonwebtoken.Jwts;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.security.Key;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNedeedFilterProvider implements ContainerRequestFilter {

    @Inject
    private KeyGenerator keyGenerator;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        String authorizationHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer: ")) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        String token = authorizationHeader.substring("Bearer:".length()).trim();

        try {
            Key key = keyGenerator.generateKey();
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        } catch (Exception e) {
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
