/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.mappers;

import com.gamersmarket.common.utils.customresponse.CustomHardwareItemBasicResponse;
import com.gamersmarket.common.utils.exceptions.EntityValidationException;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author cristiandrincu
 */
public class EntityValidationExceptionMapper implements ExceptionMapper<EntityValidationException> {

    @Inject
    private CustomHardwareItemBasicResponse basicResponse;
    
    @Override
    public Response toResponse(EntityValidationException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header("X-Entity-Validation-Exception", e.getMessage())
                .entity(basicResponse.buildValidationErrors(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage(), e.getErrors()))
                .build();
    }
    
}
