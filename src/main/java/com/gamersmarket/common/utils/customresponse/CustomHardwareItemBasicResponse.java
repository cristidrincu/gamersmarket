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
    
    @Inject
    public CustomHardwareItemBasicResponse() {}
    
    @Override
    public CustomHardwareItemBasicResponse buildStatus(int status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomHardwareItemBasicResponse buildMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public CustomHardwareItemBasicResponse buildDefaultResponse(int status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomHardwareItemBasicResponse buildDefaultResponse(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomHardwareItemBasicResponse buildDefaultResponse(int status, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

    @Override
    public CustomHardwareItemBasicResponse buildEntityDetails(HardwareItem entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
