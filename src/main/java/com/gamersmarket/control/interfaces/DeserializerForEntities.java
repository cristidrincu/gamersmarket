package com.gamersmarket.control.interfaces;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public interface DeserializerForEntities {

    JsonNode getEntityRootNode(JsonParser jsonParser, String rootNode) throws IOException;
}
