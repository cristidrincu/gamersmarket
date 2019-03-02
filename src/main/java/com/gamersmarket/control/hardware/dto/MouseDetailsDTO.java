package com.gamersmarket.control.hardware.dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gamersmarket.control.hardware.MouseRepo;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.serializers.MouseDetailsSerializer;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@JsonSerialize(using = MouseDetailsSerializer.class)
public class MouseDetailsDTO {

    private Mouse mouse;

    @Inject
    private ObjectMapperProvider objectMapperProvider;

    @Inject
    private MouseRepo mouseRepo;

    @Inject
    public MouseDetailsDTO() {}

    private MouseDetailsDTO(Mouse mouse, ObjectMapperProvider objectMapperProvider) {
        this.mouse = mouse;
        this.objectMapperProvider = objectMapperProvider;
    }

    public String buildMouseDetails(int mouseId) throws JsonProcessingException {
        Mouse mouseDetails = mouseRepo.getItem(mouseId);
        MouseDetailsDTO mouseDetailsDTO = new MouseDetailsDTO(mouseDetails, objectMapperProvider);
        return objectMapperProvider.getObjectMapper().writeValueAsString(mouseDetailsDTO);
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

    public String getHardwareItemDetails() throws JsonProcessingException {
        Map<String, String> hardwareItemDetails = new HashMap<>();
        hardwareItemDetails.put("hwItemId", String.valueOf(mouse.getHardwareItem().getId()));
        hardwareItemDetails.put("hardwareType", mouse.getHardwareItem().getHardwareType().getName());
        hardwareItemDetails.put("hardwareTypeAlias", mouse.getHardwareItem().getHardwareType().getAlias());
        hardwareItemDetails.put("manufacturerCode", mouse.getHardwareItem().getManufacturerCode());
        return objectMapperProvider.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(hardwareItemDetails);
    }
}
