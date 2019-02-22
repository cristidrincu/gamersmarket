package com.gamersmarket.utils.errors;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class ErrorBuilder {

    protected static String buildErrorMessageInvalidJsonKey(String errorMessage, JsonNode invalidJsonNode) {
        StringBuilder builder = new StringBuilder();
        builder.append(errorMessage);
        builder.append(invalidJsonNode.toString());
        return builder.toString();
    }
}
