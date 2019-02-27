package com.gamersmarket.common.utils.errors;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({"code", "field", "message"})
public class ErrorInfo implements Serializable {

    private static final long serialVersionUID = 1988623809196882824L;

    private int code;
    private String field;
    private String message;

    public ErrorInfo(int code, String field, String message) {
        this.code = code;
        this.field = field;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
