package com.stock.management.app;

import com.stock.management.app.enums.ExceptionMessage;

public class StockManagementException extends RuntimeException {
    public StockManagementException(ExceptionMessage exceptionMessage, String... params){
        super(exceptionMessage.getMessage(params));
    }
}
