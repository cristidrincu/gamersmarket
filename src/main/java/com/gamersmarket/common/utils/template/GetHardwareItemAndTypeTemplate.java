package com.gamersmarket.common.utils.template;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.common.providers.ObjectMapperProvider;

import javax.inject.Inject;
import java.io.IOException;

public abstract class GetHardwareItemAndTypeTemplate<T> {

    @Inject
    ObjectMapperProvider objectMapperProvider;

    public HardwareItem getHardwareItem(String jsonObject) throws IOException {
        return objectMapperProvider.getObjectMapper().readValue(jsonObject, HardwareItem.class);
    }

    public int getHardwareTypeId(String jsonObject) throws IOException {
        JsonNode rootNode = getRootNode(jsonObject);
        return rootNode.get("hwType").get("id").asInt();
    }

    private JsonNode getRootNode(String jsonObject) throws IOException {
        return objectMapperProvider.getObjectMapper().readTree(jsonObject);
    }

    public abstract T getSpecificHardwareItem(String jsonObject) throws IOException;
}
