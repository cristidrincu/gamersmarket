package com.gamersmarket.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.control.interfaces.DeserializerForEntities;
import com.gamersmarket.entity.hardware.HardwareItem;

import java.io.IOException;

public class HardwareItemDeserializer extends JsonDeserializer<HardwareItem> implements DeserializerForEntities {

    @Override
    public HardwareItem deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode hwItemNode = this.getEntityRootNode(jsonParser,"hwItem");
        return new HardwareItem(hwItemNode);
    }

    @Override
    public JsonNode getEntityRootNode(JsonParser jsonParser, String rootNode) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        return node.get(rootNode);
    }
}
