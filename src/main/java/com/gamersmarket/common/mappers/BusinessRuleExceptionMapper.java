/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.mappers;

import com.gamersmarket.common.utils.customresponse.CustomBasicResponse;
import com.gamersmarket.common.utils.exceptions.business.BusinessRuleException;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author cristiandrincu
 */
public class BusinessRuleExceptionMapper implements ExceptionMapper<BusinessRuleException> {

    @Inject
    private CustomBasicResponse basicResponse;
    
    @Override
    public Response toResponse(BusinessRuleException e) {
        return Response.status(Response.Status.BAD_REQUEST)                
                .entity(basicResponse.buildDefaultResponse(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()))
                .build();
    }
    
}
