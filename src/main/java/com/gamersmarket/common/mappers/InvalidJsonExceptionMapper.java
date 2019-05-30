package com.gamersmarket.common.mappers;

import com.gamersmarket.common.utils.exceptions.json.InvalidJsonException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class InvalidJsonExceptionMapper implements ExceptionMapper<InvalidJsonException> {

    @Override
    public Response toResponse(InvalidJsonException e) {
        Response.ResponseBuilder responseBuilder = Response.status(Response.Status.BAD_REQUEST);
        responseBuilder.entity(e.getErrors());
        return responseBuilder.build();
    }
}
