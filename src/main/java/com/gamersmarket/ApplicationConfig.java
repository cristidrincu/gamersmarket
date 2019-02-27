package com.gamersmarket;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.gamersmarket.boundary.GraphicCardResource;
import com.gamersmarket.boundary.HardwareItemResource;
import com.gamersmarket.boundary.HardwareTypeResource;
import com.gamersmarket.boundary.MouseResource;
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
                InvalidJsonExceptionMapper.class,
                ValidationExceptionMapper.class
        );

        register(ObjectMapperProvider.class);
        register(JacksonFeatures.class);
        property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);
    }
}
