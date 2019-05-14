package com.gamersmarket.common.utils;

import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.HardwareOffer;
import java.util.List;
import javax.inject.Inject;

public class CustomBasicResponse {
    
    private int status;
    private String message;   
    
    private HardwareItem hardwareItem;
    private Gamer gamer;
    private List<? extends HardwareItem> hardwareItems;    
    private List<HardwareOffer> hardwareOffers;

    @Inject
    public CustomBasicResponse() {}   

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

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }        

    public List<? extends HardwareItem> getHardwareItems() {
        return hardwareItems;
    }

    public void setHardwareItems(List<? extends HardwareItem> hardwareItems) {
        this.hardwareItems = hardwareItems;
    }

    public List<HardwareOffer> getHardwareOffers() {
        return hardwareOffers;
    }

    public void setHardwareOffers(List<HardwareOffer> hardwareOffers) {
        this.hardwareOffers = hardwareOffers;
    }                    
    
    public CustomBasicResponse buildDefaultResponse(String message) {
        return this.buildMessage(message);
    }
    
    public CustomBasicResponse buildDefaultResponse(int statusCode, String message) {                
        return this.buildStatus(statusCode).buildMessage(message);
    }
    
    public CustomBasicResponse buildResponseHardwareItem(int statusCode, String message, HardwareItem hwItem) {
        return this.buildStatus(statusCode).buildMessage(message).buildHardwareItemDetails(hwItem);                
    }
    
    public CustomBasicResponse buildResponseGamer(int statusCode, String message, Gamer gamer) {
        return this.buildStatus(statusCode).buildMessage(message).buildGamerDetails(gamer);                
    }
    
    public CustomBasicResponse buildResponseHardwareItems(int statusCode, String message, List<? extends HardwareItem> hwItems) {
        return this.buildStatus(statusCode).buildMessage(message).buildHardwareItems(hwItems);                
    }
    
    public CustomBasicResponse buildResponseHardwareOffers(int statusCode, String message, List<HardwareOffer> hwOffers) {
        return this.buildStatus(statusCode).buildMessage(message).buildHardwareOffers(hwOffers);                
    }         

    private CustomBasicResponse buildStatus(int statusCode) {
        setStatus(statusCode);
        return this;
    }
        
    private CustomBasicResponse buildMessage(String message) {
        setMessage(message);
        return this;
    }
    
    private CustomBasicResponse buildHardwareItemDetails(HardwareItem hwItem) {
        setHardwareItem(hwItem);
        return this;
    }
    
    private CustomBasicResponse buildGamerDetails(Gamer gamer) {
        setGamer(gamer);
        return this;
    }
    
    private CustomBasicResponse buildHardwareItems(List<? extends HardwareItem> hwItems) {
        this.setHardwareItems(hwItems);
        return this;
    }
    
    private CustomBasicResponse buildHardwareOffers(List<HardwareOffer> hwOffers) {
        this.setHardwareOffers(hwOffers);
        return this;
    }                
}