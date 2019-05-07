package com.gamersmarket.common.utils.template.hardware;

import com.gamersmarket.entity.hardware.GraphicsCard;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GraphicsCardTemplate extends HardwareItemAndTypeTemplate<GraphicsCard> {   

    @Override
    public GraphicsCard getSpecificHardwareItem(String jsonObject) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        objectMapperProvider.getContext(GraphicsCardTemplate.class).setDateFormat(dateFormat);
        return objectMapperProvider.getObjectMapper().readValue(jsonObject, GraphicsCard.class);
    }
}