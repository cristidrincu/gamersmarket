/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.mappers;

import com.gamersmarket.common.utils.customresponse.CustomBasicResponse;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author cristiandrincu
 */
public class PersistenceExceptionMapper implements ExceptionMapper<PersistenceException> {

    @Inject
    private CustomBasicResponse basicResponse;
    
    @Override
    public Response toResponse(PersistenceException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header("X-Persistence-Exception", e.getMessage())
                .entity(basicResponse.buildDefaultResponse(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()))
                .build();                
    }
    
}
