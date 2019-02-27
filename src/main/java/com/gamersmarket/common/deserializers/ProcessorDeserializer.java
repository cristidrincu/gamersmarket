package com.gamersmarket.common.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.interfaces.DeserializerForEntities;
import com.gamersmarket.entity.hardware.Processor;

import java.io.IOException;

public class ProcessorDeserializer extends JsonDeserializer<Processor> implements DeserializerForEntities {

    @Override
    public Processor deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode processorNode = this.getEntityRootNode(jsonParser, "processor");
        return new Processor(processorNode);
    }

    @Override
    public JsonNode getEntityRootNode(JsonParser jsonParser, String rootNode) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        return node.get(rootNode);
    }
}
