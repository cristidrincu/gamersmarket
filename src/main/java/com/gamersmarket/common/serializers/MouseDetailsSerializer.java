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
        jsonGenerator.writeStringField("connectionType", mouseDetailsDTO.getConnectionType());
        jsonGenerator.writeStringField("manufacturerCode", mouseDetailsDTO.getManufacturerCode());
        jsonGenerator.writeStringField("hardwareType", mouseDetailsDTO.getHardwareType());
        jsonGenerator.writeEndObject();
    }
}
