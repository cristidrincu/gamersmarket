package com.gamersmarket.common.utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.utils.errors.ErrorBuilder;
import com.gamersmarket.common.utils.errors.ErrorInfo;
import com.gamersmarket.common.utils.exceptions.json.InvalidJsonException;

import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateValidator extends ErrorBuilder {

    private static final int BAD_REQUEST_STATUS_CODE = Response.Status.BAD_REQUEST.getStatusCode();
    private static final String ERROR_MESSAGE = "Invalid date property when parsing json: ";
    private static final Logger logger = Logger.getLogger(DateValidator.class.getName());
    private static final List<ErrorInfo> errors = new ArrayList<>();

    public static Date parseDate(JsonNode dateToValidate, String format) {

        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);

        try {
            date = dateFormat.parse(dateToValidate.asText());
        } catch (ParseException e) {
            if (errors.isEmpty()) {
                errors.add(new ErrorInfo(BAD_REQUEST_STATUS_CODE, dateToValidate.asText(), buildErrorMessageInvalidJsonKey(ERROR_MESSAGE, dateToValidate)));
            }

            logger.log(Level.INFO, "Exception thrown when parsing date. Reason: " + e.getMessage());
            throw new InvalidJsonException("Invalid json key exception.", errors);
        }

        return date;
    }
}
