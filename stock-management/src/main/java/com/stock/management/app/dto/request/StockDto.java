package com.stock.management.app.dto.request;

import lombok.Data;

@Data
public class StockDto {

    private int id;
    private String code;
    private String name;
    private String market;
    private double price;
    private double dps;
    private double per;
}
