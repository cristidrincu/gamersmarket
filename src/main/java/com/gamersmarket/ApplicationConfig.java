package com.gamersmarket;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.gamersmarket.boundary.*;
import com.gamersmarket.common.mappers.AccountAlreadyExistsExceptionMapper;
import com.gamersmarket.common.mappers.HardwareBidAmountExceptionMapper;
import com.gamersmarket.common.mappers.InvalidJsonExceptionMapper;
import com.gamersmarket.common.mappers.JsonParsingExceptionMapper;
import com.gamersmarket.common.mappers.NoAccountExistsExceptionMapper;
import com.gamersmarket.common.mappers.NoEntityFoundExceptionMapper;
import com.gamersmarket.common.providers.CORSFilterProvider;
import com.gamersmarket.common.providers.filters.JsonFilterProvider;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/explore")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        registerClasses(
                HardwareTypeResource.class,                
                HardwareBidResource.class,
                MouseResource.class,
                KeyboardResource.class,
                GraphicsCardResource.class,
                ProcessorResource.class,
                GamersResource.class,
                HardwareOfferResource.class,
                InvalidJsonExceptionMapper.class,
                NoAccountExistsExceptionMapper.class,
                AccountAlreadyExistsExceptionMapper.class,
                NoEntityFoundExceptionMapper.class,                
                HardwareBidAmountExceptionMapper.class,
                JsonParsingExceptionMapper.class
        );

        register(CORSFilterProvider.class);
        register(JsonFilterProvider.class);
        register(ObjectMapperProvider.class);       
        register(JacksonFeatures.class);
        property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);
    }
}
