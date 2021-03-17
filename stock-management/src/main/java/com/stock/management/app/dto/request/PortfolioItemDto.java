package com.stock.management.app.dto.request;

import lombok.Data;

@Data
public class PortfolioItemDto {
    private Long portfolioId;
    private Long stockId;
    private Integer quantity;
    private Double price;
}
