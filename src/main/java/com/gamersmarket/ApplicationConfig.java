package com.gamersmarket;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.gamersmarket.boundary.*;
import com.gamersmarket.common.mappers.AccountAlreadyExistsExceptionMapper;
import com.gamersmarket.common.mappers.InvalidJsonExceptionMapper;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.validation.internal.ValidationExceptionMapper;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/explore")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig(){
        registerClasses(
                HardwareTypeResource.class,
                HardwareItemResource.class,
                MouseResource.class,
                GraphicCardResource.class,
                GamersResource.class,
                InvalidJsonExceptionMapper.class,
                AccountAlreadyExistsExceptionMapper.class,
                ValidationExceptionMapper.class
        );

        register(ObjectMapperProvider.class);
        register(JacksonFeatures.class);
        property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);
    }
}
