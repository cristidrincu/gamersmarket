/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.mappers;

import com.gamersmarket.common.utils.CustomBasicResponse;
import com.gamersmarket.common.utils.exceptions.NoEntityFoundException;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author cristiandrincu
 */
public class NoEntityFoundExceptionMapper implements ExceptionMapper<NoEntityFoundException> {

    @Inject
    private CustomBasicResponse basicResponse;
    
    @Override
    public Response toResponse(NoEntityFoundException e) {        
        return Response.status(Response.Status.BAD_REQUEST)
                .header("X-No-Entity-Found", e.getMessage())
                .entity(basicResponse.buildDefaultResponse(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()))
                .build();                
    }
    
}