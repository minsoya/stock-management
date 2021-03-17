package com.stock.management.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;

@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
    private static final String defaultMessage = "SUCCESS";

    private boolean success;
    private String message;
    private T data;

    public static <T> ApiResponse success(T data){
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(defaultMessage);
        response.setData(data);
        return response;
    }

    public static <T> ApiResponse success(){
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(defaultMessage);
        return response;
    }

    public static <T> ApiResponse fail(String message){
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

}
