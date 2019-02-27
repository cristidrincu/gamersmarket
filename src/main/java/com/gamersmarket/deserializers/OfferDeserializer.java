package com.gamersmarket.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.control.interfaces.DeserializerForEntities;
import com.gamersmarket.entity.hardware.HardwareOffer;

import java.io.IOException;

public class OfferDeserializer extends JsonDeserializer<HardwareOffer> implements DeserializerForEntities {

    @Override
    public HardwareOffer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode offerNode = this.getEntityRootNode(jsonParser, "hardwareOffer");
        return new HardwareOffer(offerNode);
    }

    @Override
    public JsonNode getEntityRootNode(JsonParser jsonParser, String rootNode) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        return node.get(rootNode);
    }
}
