package com.gamersmarket.common.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.gamersmarket.control.hardware.dto.MouseDetailsDTO;

import java.io.IOException;

public class MouseDetailsSerializer extends JsonSerializer<MouseDetailsDTO> {

    @Override
    public void serialize(MouseDetailsDTO mouseDetailsDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", mouseDetailsDTO.getMouseId());
        jsonGenerator.writeStringField("connectionType", mouseDetailsDTO.getConnectionType());
        jsonGenerator.writeStringField("sensorTechnology", mouseDetailsDTO.getSensorTechnology());
        jsonGenerator.writeStringField("buttons", mouseDetailsDTO.getNumberOfButtons());
        jsonGenerator.writeStringField("scrollingButtons", mouseDetailsDTO.getNumberOfScrollingButtons());
        jsonGenerator.writeStringField("colour", mouseDetailsDTO.getColour());
        jsonGenerator.writeStringField("illumination", String.valueOf(mouseDetailsDTO.hasIllumination() > 0));
        jsonGenerator.writeStringField("ledColour", mouseDetailsDTO.getLedColour());
        jsonGenerator.writeStringField("cableLength", mouseDetailsDTO.getCableLength());
        jsonGenerator.writeStringField("weight", mouseDetailsDTO.getWeight());
        jsonGenerator.writeStringField("dpi", String.valueOf(mouseDetailsDTO.getDpi()));
        jsonGenerator.writeStringField("wireless", String.valueOf(mouseDetailsDTO.isWireless() > 0));        
        jsonGenerator.writeEndObject();
    }
}
