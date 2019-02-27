package com.gamersmarket.control.hardware.dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gamersmarket.control.hardware.MouseRepo;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.serializers.MouseDetailsSerializer;

import javax.inject.Inject;

@JsonSerialize(using = MouseDetailsSerializer.class)
public class MouseDetailsDTO {

    private Mouse mouse;
    private ObjectMapperProvider objectMapperProvider;

    @Inject
    MouseRepo mouseRepo;

    @Inject
    public MouseDetailsDTO() {
        objectMapperProvider = new ObjectMapperProvider();
    }

    private MouseDetailsDTO(Mouse mouse) {
        this.mouse = mouse;
    }

    public String buildMouseDetails(int mouseId) throws JsonProcessingException {
        Mouse mouseDetails = mouseRepo.getItem(mouseId);
        MouseDetailsDTO mouseDetailsDTO = new MouseDetailsDTO(mouseDetails);
        return objectMapperProvider.objectMapper.writeValueAsString(mouseDetailsDTO);
    }

    public String getConnectionType() {
        return this.mouse.getConnectionType();
    }

    public String getManufacturerCode() {
        return this.mouse.getHardwareItem().getManufacturerCode();
    }

    public String getHardwareType() {
        return this.mouse.getHardwareItem().getHardwareType().getName();
    }
}
