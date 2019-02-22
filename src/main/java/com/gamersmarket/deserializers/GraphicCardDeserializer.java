package com.gamersmarket.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.entity.hardware.GraphicsCard;

import java.io.IOException;

public class GraphicCardDeserializer extends JsonDeserializer<GraphicsCard> {

    @Override
    public GraphicsCard deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        JsonNode graphicCardNode = node.get("graphicCard");
        return new GraphicsCard(graphicCardNode);
    }
}
