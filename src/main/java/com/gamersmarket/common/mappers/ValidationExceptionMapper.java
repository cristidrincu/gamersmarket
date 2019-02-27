package com.gamersmarket.common.mappers;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        return null;
//        List<ValidationError> errors = e.getConstraintViolations().stream().map(this::toValidationError).collect(Collectors.toList());
//
//        return Response.status(Response.Status.BAD_REQUEST)
//                .header("X-Validation-Exception", Response.Status.BAD_REQUEST)
//                .entity(new BasicResponse(Response.Status.BAD_REQUEST.getStatusCode(), "Validation failed", errors))
//                .type(MediaType.APPLICATION_JSON)
//                .build();
//    }
//
//    private ValidationError toValidationError(ConstraintViolation constraintViolation) {
//        ValidationError error = new ValidationError();
//        error.setLeafBean(constraintViolation.getLeafBean().toString());
//        error.setPath(constraintViolation.getPropertyPath().toString());
//        error.setInvalidValue(constraintViolation.getInvalidValue().toString());
//        error.setMessage(constraintViolation.getMessage());
//        return error;
//    }
    }
}
