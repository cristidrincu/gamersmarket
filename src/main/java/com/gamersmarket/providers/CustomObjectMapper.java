package com.gamersmarket.providers;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gamersmarket.deserializers.HardwareItemDeserializer;
import com.gamersmarket.deserializers.MouseDeserializer;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.Mouse;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomObjectMapper implements ContextResolver<ObjectMapper> {

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        final ObjectMapper result = new ObjectMapper();

        SimpleModule mouseModule = new SimpleModule("MouseDeserializer", new Version(1, 0, 0, null, null, null));
        SimpleModule hardwareItemModule = new SimpleModule("HardwareDeserializer", new Version(1, 0, 0, null, null, null)).addDeserializer(HardwareItem.class, new HardwareItemDeserializer());

        mouseModule.addDeserializer(Mouse.class, new MouseDeserializer());
        hardwareItemModule.addDeserializer(HardwareItem.class, new HardwareItemDeserializer());

        result.registerModules(mouseModule, hardwareItemModule);
        return result;
    }
}
