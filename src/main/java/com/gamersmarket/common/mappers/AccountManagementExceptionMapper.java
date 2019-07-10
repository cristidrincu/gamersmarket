package com.gamersmarket.common.mappers;

import com.gamersmarket.common.utils.customresponse.CustomBasicResponse;
import com.gamersmarket.common.utils.exceptions.business.accountmanagement.AccountManagementException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AccountManagementExceptionMapper implements ExceptionMapper<AccountManagementException> {

    @Inject
    private CustomBasicResponse basicResponse;

    @Override
    public Response toResponse(AccountManagementException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header("X-Account-Already-Exists", e.getMessage())
                .entity(basicResponse.buildDefaultResponse(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()))
                .build();
    }
}
