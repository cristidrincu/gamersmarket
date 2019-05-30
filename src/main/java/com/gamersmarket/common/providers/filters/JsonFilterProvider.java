/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.providers.filters;

import com.gamersmarket.common.annotations.jerseyfilters.ValidateBasicCredentials;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.common.utils.exceptions.persistence.NoAccountExistsException;
import com.google.common.base.Charsets;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author cristiandrincu
 */
@ValidateBasicCredentials
public class JsonFilterProvider implements ContainerRequestFilter {

    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());
    
    @Inject
    JsonUtils jsonUtils;
    
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        if (isJson(request)) {
            String json = IOUtils.toString(request.getEntityStream(), Charsets.UTF_8);            
            String email = jsonUtils.readEmailAddressFromNode(json);
            String password = jsonUtils.readPasswordFromNode(json);
            
            if (!isValidEmail(email)) {
                LOGGER.log(Level.WARNING, "Invalid email format.");
                throw new NoAccountExistsException("Invalid email or password. Please try again!");
            }
            
            if (!isValidPassword(password)) {                
                LOGGER.log(Level.WARNING, MessageFormat.format("Password length criteria not met. Must be between {0} and {1}. Password length was: {2}",
                        5, 10, password.length()));
                throw new NoAccountExistsException("Invalid email or password. Please try again!");
            }
            
            InputStream parsedJson = IOUtils.toInputStream(json);
            request.setEntityStream(parsedJson);
        }
    }
    
    private boolean isJson(ContainerRequestContext request) {
        return request.getMediaType().toString().contains("application/json");
    }
    
    //this method should reside in a class ValidatorUtils
    private boolean isValidEmail(String email) {
       String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
       return email.matches(regex);
    }
    
    //this method should reside in a class ValidatorUtils
    private boolean isValidPassword(String password) {
        return password.length() > 5 && password.length() <= 10;
    }
    
}
