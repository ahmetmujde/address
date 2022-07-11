package com.cloudsoftware.address.dto.response;

public class ErrorResponse {

    private String message;

    public static ErrorResponse create(String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(message);
        return errorResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
