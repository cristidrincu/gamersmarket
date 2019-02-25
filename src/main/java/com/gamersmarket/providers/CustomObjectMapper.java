package com.gamersmarket.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gamersmarket.deserializers.*;
import com.gamersmarket.entity.hardware.*;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomObjectMapper implements ContextResolver<ObjectMapper> {

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        final ObjectMapper result = new ObjectMapper();

        SimpleModule hardwareOfferModule = new SimpleModule("HardwareOffer");

        hardwareOfferModule.addDeserializer(Offer.class, new OfferDeserializer());

        result.registerModules(hardwareOfferModule);
        return result;
    }
}
