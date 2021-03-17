package com.stock.management.app.enums;

import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;

@Getter
public enum Market {
    NASDAQ("나스닥", Country.US),
    NYSE("뉴욕증권거래소", Country.US),
    AMEX("아멕스", Country.US),
    KOSPI("코스피", Country.KR),
    KOSDAQ("코스닥", Country.KR),
    ETF_KR("한국상장ETF", Country.KR),
    ETF_US("미국상장ETF", Country.US),
    UNKNOWN("알수없음", Country.ETC);

    private String text;
    private Country country;

    Market(String text, Country country) {
        this.text = text;
        this.country = country;
    }

    public static Market of(String value) {
        return Arrays.stream(Market.values())
                .filter(x -> StringUtils.equalsIgnoreCase(value, x.name()))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
