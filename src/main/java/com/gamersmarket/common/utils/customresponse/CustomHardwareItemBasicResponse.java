/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.utils.customresponse;

import com.gamersmarket.common.interfaces.BasicResponse;
import com.gamersmarket.entity.hardware.HardwareItem;
import javax.inject.Inject;

/**
 *
 * @author cristiandrincu
 */
public class CustomHardwareItemBasicResponse implements BasicResponse<CustomHardwareItemBasicResponse, HardwareItem> {

    private int status;
    private String message;   
    private HardwareItem hardwareItem;

    @Inject
    public CustomHardwareItemBasicResponse() {}
    
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
    
    @Override
    public CustomHardwareItemBasicResponse buildDefaultResponse(int status) {
        return this.buildStatus(status);
    }

    @Override
    public CustomHardwareItemBasicResponse buildDefaultResponse(String message) {
        return this.buildMessage(message);
    }

    @Override
    public CustomHardwareItemBasicResponse buildDefaultResponse(int status, String message) {
        return this.buildStatus(status).buildMessage(message);
    }   

    @Override
    public CustomHardwareItemBasicResponse buildEntityDetails(HardwareItem entity) {
        this.setHardwareItem(entity);
        return this;
    }
    
    @Override
    public CustomHardwareItemBasicResponse buildStatus(int status) {
        this.setStatus(status);
        return this;
    }

    @Override
    public CustomHardwareItemBasicResponse buildMessage(String message) {
        this.setMessage(message);
        return this;
    }
    
    public CustomHardwareItemBasicResponse buildResponseHardwareItem(int status, String message, HardwareItem hwItem) {
        return this.buildStatus(status).buildMessage(message).buildEntityDetails(hwItem);
    }    
}
