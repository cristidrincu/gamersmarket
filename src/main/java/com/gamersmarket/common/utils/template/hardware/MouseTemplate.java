package com.gamersmarket.common.utils.template.hardware;
import com.gamersmarket.entity.hardware.Mouse;

import java.io.IOException;


public class MouseTemplate extends HardwareItemAndTypeTemplate<Mouse> {      

    @Override
    public Mouse getSpecificHardwareItem(String jsonObject) throws IOException {
        return objectMapperProvider.getContext(MouseTemplate.class).readValue(jsonObject, Mouse.class);
    }
}
