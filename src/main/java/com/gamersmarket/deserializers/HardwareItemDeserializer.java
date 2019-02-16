package com.gamersmarket.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.entity.hardware.HardwareItem;

import java.io.IOException;

public class HardwareItemDeserializer extends JsonDeserializer<HardwareItem> {

    @Override
    public HardwareItem deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        JsonNode hwItemNode = node.get("hwItem");

        return new HardwareItem(hwItemNode);
    }
}
