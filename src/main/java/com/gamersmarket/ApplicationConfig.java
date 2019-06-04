package com.gamersmarket;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.gamersmarket.boundary.*;
import com.gamersmarket.common.mappers.AccountManagementExceptionMapper;
import com.gamersmarket.common.mappers.EntityValidationExceptionMapper;
import com.gamersmarket.common.mappers.BusinessRuleExceptionMapper;
import com.gamersmarket.common.mappers.InvalidJsonExceptionMapper;
import com.gamersmarket.common.mappers.JsonParsingExceptionMapper;
import com.gamersmarket.common.mappers.PersistenceExceptionMapper;
import com.gamersmarket.common.providers.CORSFilterProvider;
import com.gamersmarket.common.providers.filters.JsonFilterProvider;
import com.gamersmarket.common.providers.ObjectMapperProvider;
import com.gamersmarket.common.providers.filters.MousePayloadFilterProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/explore")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        registerClasses(HardwareTypeResource.class,                
                HardwareBidResource.class,
                MouseResource.class,
                KeyboardResource.class,
                GraphicsCardResource.class,
                ProcessorResource.class,
                GamersResource.class,
                HardwareOfferResource.class,
                LanguageResource.class,
                TranslationResource.class,
                InvalidJsonExceptionMapper.class,
                AccountManagementExceptionMapper.class,
                EntityValidationExceptionMapper.class,
                PersistenceExceptionMapper.class,
                BusinessRuleExceptionMapper.class,
                JsonParsingExceptionMapper.class
        );
        
        register(ObjectMapperProvider.class);       
        register(JacksonFeatures.class);
        register(CORSFilterProvider.class);
        register(JsonFilterProvider.class);
        register(MousePayloadFilterProvider.class);
        property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);
    }
}
