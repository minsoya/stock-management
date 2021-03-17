package com.stock.management.app.dto.request;

import lombok.Data;

@Data
public class StockPriceDto {

    private String code;
    private String date;
    private String market;
    private double high;
    private double low;
    private double open;
    private double close;
    private long volume;
}
