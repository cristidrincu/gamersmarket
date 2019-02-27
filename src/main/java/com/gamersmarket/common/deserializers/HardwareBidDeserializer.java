package com.gamersmarket.common.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.interfaces.DeserializerForEntities;
import com.gamersmarket.entity.bid.HardwareBid;

import java.io.IOException;

public class HardwareBidDeserializer extends JsonDeserializer<HardwareBid> implements DeserializerForEntities {

    @Override
    public HardwareBid deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode hardwareBidRootNode = this.getEntityRootNode(jsonParser, "hardwareBid");
        return new HardwareBid(hardwareBidRootNode);
    }

    @Override
    public JsonNode getEntityRootNode(JsonParser jsonParser, String rootNode) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        return node.get(rootNode);
    }
}
