package com.gamersmarket.control.hardware.dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gamersmarket.control.hardware.MouseRepo;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.serializers.MouseDetailsSerializer;
import java.util.List;

import javax.inject.Inject;

@JsonSerialize(using = MouseDetailsSerializer.class)
public class MouseDetailsDTO {

    private Mouse mouse;        
    private ObjectMapperProvider objectMapperProvider;

    @Inject
    private MouseRepo mouseRepo;
    
    public MouseDetailsDTO() {}

    @Inject
    private MouseDetailsDTO(Mouse mouse, ObjectMapperProvider objectMapperProvider) {
        this.mouse = mouse;
        this.objectMapperProvider = objectMapperProvider;        
    }

    public String buildMouseDetails(int mouseId) throws JsonProcessingException {
        Mouse mouseDetails = mouseRepo.getItem(mouseId);
        MouseDetailsDTO mouseDetailsDTO = new MouseDetailsDTO(mouseDetails, objectMapperProvider);
        return objectMapperProvider.getContext(MouseDetailsDTO.class).writeValueAsString(mouseDetailsDTO);
    }
    
    public List<Mouse> buildMiceList() {
        return mouseRepo.getItems();        
    }

    public String getMouseId() {
        return String.valueOf(mouse.getId());
    }

    public String getConnectionType() {
        return mouse.getConnectionType();
    }

    public String getSensorTechnology() {
        return mouse.getSensorTechnology();
    }

    public String getNumberOfButtons() {
        return String.valueOf(mouse.getButtons());
    }

    public String getNumberOfScrollingButtons() {
        return String.valueOf(mouse.getScrollingButtons());
    }

    public String getColour() {
        return mouse.getColour();
    }

    public String getLedColour() {
        return mouse.getLedColor();
    }

    public int hasIllumination() {
        return mouse.getHasIllumination();
    }

    public String getCableLength() {
        return mouse.getCableLength();
    }

    public String getWeight() {
        return mouse.getWeight();
    }

    public int getDpi() {
        return mouse.getDpi();
    }

    public int isWireless() {
        return mouse.getIsWireless();
    }       
}
