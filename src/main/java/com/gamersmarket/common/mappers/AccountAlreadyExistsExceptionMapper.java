package com.gamersmarket.common.mappers;

import com.gamersmarket.common.utils.customresponse.CustomBasicResponse;
import com.gamersmarket.common.utils.exceptions.AccountAlreadyExistsException;
import javax.inject.Inject;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AccountAlreadyExistsExceptionMapper implements ExceptionMapper<AccountAlreadyExistsException> {

    @Inject
    private CustomBasicResponse basicResponse;

    @Override
    public Response toResponse(AccountAlreadyExistsException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header("X-Account-Already-Exists", e.getMessage())
                .entity(basicResponse.buildDefaultResponse(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()))
                .build();
    }
}
