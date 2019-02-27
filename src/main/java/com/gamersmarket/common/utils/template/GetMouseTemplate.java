package com.gamersmarket.common.utils.template;
import com.gamersmarket.entity.hardware.Mouse;

import java.io.IOException;

public class GetMouseTemplate extends GetHardwareItemAndTypeTemplate<Mouse> {

    @Override
    public Mouse getSpecificHardwareItem(String jsonObject) throws IOException {
        return objectMapperProvider.objectMapper.readValue(jsonObject, Mouse.class);
    }
}
