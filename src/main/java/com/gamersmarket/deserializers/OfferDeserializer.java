package com.gamersmarket.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.entity.hardware.Offer;

import java.io.IOException;

public class OfferDeserializer extends JsonDeserializer<Offer> {

    @Override
    public Offer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        JsonNode offerNode = node.get("hardwareOffer");
        return new Offer(offerNode);
    }
}
