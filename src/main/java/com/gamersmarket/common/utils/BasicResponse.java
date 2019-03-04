package com.gamersmarket.common.utils;

import javax.inject.Inject;

public class BasicResponse {

    private int status;
    private String message;

    @Inject
    public BasicResponse() {}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BasicResponse buildResponse(int statusCode, String message) {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setStatus(statusCode);
        basicResponse.setMessage(message);

        return basicResponse;
    }
}
