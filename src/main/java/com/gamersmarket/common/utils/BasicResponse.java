package com.gamersmarket.common.utils;

import com.gamersmarket.entity.hardware.HardwareItem;
import javax.inject.Inject;

public class BasicResponse {

    private int status;
    private String message;
    private HardwareItem hardwareItem;

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

    public HardwareItem getHardwareItem() {
        return hardwareItem;
    }

    public void setHardwareItem(HardwareItem hardwareItem) {
        this.hardwareItem = hardwareItem;
    }        

    public BasicResponse buildResponse(int statusCode, String message) {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setStatus(statusCode);
        basicResponse.setMessage(message);

        return basicResponse;
    }
    
    public BasicResponse buildResponse(int statusCode, String message, HardwareItem hwItem) {
        return this.buildStatus(statusCode).buildMessage(message).buildHardwareItemDetails(hwItem);                
    }
    
    private BasicResponse buildStatus(int statusCode) {
        this.setStatus(statusCode);
        return this;
    }
    
    private BasicResponse buildMessage(String message) {
        this.setMessage(message);
        return this;
    }
    
    private BasicResponse buildHardwareItemDetails(HardwareItem hwItem) {
        this.setHardwareItem(hwItem);
        return this;
    }
}
