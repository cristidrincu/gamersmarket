package com.gamersmarket.common.utils.template;

import com.gamersmarket.entity.hardware.GraphicsCard;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GetGraphicsCardTemplate extends GetHardwareItemAndTypeTemplate<GraphicsCard> {

    @Override
    public GraphicsCard getSpecificHardwareItem(String jsonObject) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        objectMapperProvider.getObjectMapper().setDateFormat(dateFormat);
        return objectMapperProvider.getObjectMapper().readValue(jsonObject, GraphicsCard.class);
    }
}
