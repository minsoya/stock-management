package com.stock.management.app.entity;

import com.stock.management.app.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "portfolio_item")
public class PortfolioItem extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Integer quantity;

    private double purchasePriceSum;

    @JoinColumn(name = "stockId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    @JoinColumn(name = "portfolioId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Portfolio portfolio;
}
