package com.gamersmarket.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.entity.hardware.Keyboard;

import java.io.IOException;

public class KeyboardDeserializer extends JsonDeserializer<Keyboard> {

    @Override
    public Keyboard deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        JsonNode keyboardNode = node.get("keyboard");
        return new Keyboard(keyboardNode);
    }
}
