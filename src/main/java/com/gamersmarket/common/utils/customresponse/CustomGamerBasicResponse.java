package com.gamersmarket.common.utils.customresponse;

import com.gamersmarket.common.interfaces.BasicResponse;
import com.gamersmarket.entity.gamers.Gamer;
import javax.inject.Inject;

/**
 *
 * @author cristiandrincu
 */
public class CustomGamerBasicResponse implements BasicResponse<CustomGamerBasicResponse, Gamer> {
    
    private int status;
    private String message;
    private Gamer gamer;
    
    @Inject
    public CustomGamerBasicResponse() {}

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
            
    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }    

    @Override
    public CustomGamerBasicResponse buildStatus(int status) {
        setStatus(status);
        return this;
    }

    @Override
    public CustomGamerBasicResponse buildMessage(String message) {
        setMessage(message);
        return this;
    }
    
    @Override
    public CustomGamerBasicResponse buildEntityDetails(Gamer entity) {
        setGamer(entity);
        return this;
    }   

    @Override
    public CustomGamerBasicResponse buildDefaultResponse(int status) {
        return buildStatus(status);
    }

    @Override
    public CustomGamerBasicResponse buildDefaultResponse(String message) {
        return this.buildMessage(message);
    }

    @Override
    public CustomGamerBasicResponse buildDefaultResponse(int status, String message) {
        return this.buildStatus(status).buildMessage(message);
    }
    
    public CustomGamerBasicResponse buildResponseGamer(int status, String message, Gamer gamer) {
        return this.buildStatus(status).buildMessage(message).buildEntityDetails(gamer);
    }
}
