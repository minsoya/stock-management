package com.stock.management.app.enums;

import lombok.Getter;

@Getter
public enum Country {
    KR("한국"),
    US("미국"),
    CN("중국"),
    ETC("기타");

    private String text;

    Country(String text) {
        this.text = text;
    }
}
