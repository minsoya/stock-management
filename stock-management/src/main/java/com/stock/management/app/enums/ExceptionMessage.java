package com.stock.management.app.enums;

import lombok.Getter;

public enum ExceptionMessage {

    // portfolio
    PORTFOLIO_NOT_FOUND("존재하지 않는 포트폴리오입니다. id:%s"),
    PORTFOLIO_ITEM_NOT_FOUND("존재하지 않는 포트폴리오 아이템입니다. id:%s"),
    // stock
    STOCK_NOT_FOUND("존재하지 않는 종목입니다. id:%s"),
    DUPLICATE_STOCK_FOUND("이미 저장된 종목입니다. code:%s, market:%s"),
    // general
    PARAMETER_IS_NULL("[%s] 파라미터가 비어있습니다.")
    ;

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getMessage(String... params){
        return String.format(message, params);
    }
}
