package com.gamersmarket.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import javax.ws.rs.ext.ContextResolver;

public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    public final ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        this.objectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return objectMapper;
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.registerModule(new JaxbAnnotationModule());
        return result;
    }
}
