package com.ejercico.springboot.model;

import java.util.Date;

public class CustomExceptionResponse {
    private String message;
    private Date date;
    private String details;

    public CustomExceptionResponse() {

    }


    public CustomExceptionResponse(String message, Date date, String details) {
        this.message = message;
        this.date = date;
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
