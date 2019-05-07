package com.gamersmarket.common.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.interfaces.DeserializerForEntities;
import com.gamersmarket.entity.gamers.Gamer;

import java.io.IOException;

public class GamerDeserializer extends JsonDeserializer<Gamer> implements DeserializerForEntities {

    @Override
    public Gamer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode gamerNode = getEntityRootNode(jsonParser, "");
        return new Gamer(gamerNode);
    }

    @Override
    public JsonNode getEntityRootNode(JsonParser jsonParser, String rootNode) throws IOException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode node = objectCodec.readTree(jsonParser);
        return rootNode.isEmpty() ? node : node.get(rootNode);
    }
}
