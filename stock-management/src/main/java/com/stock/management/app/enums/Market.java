package com.stock.management.app.enums;

import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;

@Getter
public enum Market {
    NASDAQ("나스닥", Country.US),
    SNP("S&P500", Country.US),
    RUSSELL("러셀", Country.US),
    KOSPI("코스피", Country.KR),
    KOSDAK("코스닥", Country.KR),
    ETC("기타", Country.ETC);

    private String text;
    private Country country;

    Market(String text, Country country) {
        this.text = text;
        this.country = country;
    }

    public static Market of(String value) {
        return Arrays.stream(Market.values())
                .filter(x -> StringUtils.equalsIgnoreCase(value, x.getText()))
                .findFirst()
                .orElse(ETC);
    }
}
