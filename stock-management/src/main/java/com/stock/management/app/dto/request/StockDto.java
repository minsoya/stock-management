package com.stock.management.app.dto.request;

import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
public class StockDto {

    private Long id;
    private String code;
    private String name;
    private String market;
    private double price;
    private Map<Integer, Double> dividendMap;
    private Long volume;
}
