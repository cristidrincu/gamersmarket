package com.gamersmarket.common.utils.template.hardware;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.common.providers.ObjectMapperProvider;


import java.io.IOException;
import javax.inject.Inject;

public abstract class HardwareItemAndTypeTemplate<T> {
    
    @Inject
    protected ObjectMapperProvider objectMapperProvider;
        
    public HardwareItem getHardwareItem(String jsonObject) throws IOException {
        return objectMapperProvider.getContext(HardwareItemAndTypeTemplate.class).readValue(jsonObject, HardwareItem.class);
    }

    public int getHardwareTypeId(String jsonObject) throws IOException {
        JsonNode rootNode = getRootNode(jsonObject);
        return rootNode.get("hwType").get("id").asInt();
    }

    private JsonNode getRootNode(String jsonObject) throws IOException {
        return objectMapperProvider.getContext(HardwareItemAndTypeTemplate.class).readTree(jsonObject);
    }

    public abstract T getSpecificHardwareItem(String jsonObject) throws IOException;
}
