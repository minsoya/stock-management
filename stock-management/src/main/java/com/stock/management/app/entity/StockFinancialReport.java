package com.stock.management.app.entity;

import com.stock.management.app.BaseEntity;
import com.stock.management.app.enums.Market;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "stock_financial_report")
public class StockFinancialReport extends BaseEntity {
    @Id
    @GeneratedValue
    private int id;

    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;
    @NonNull
    private String updateMonth;

    private float pastPer;
    private float per;

    private float salesAmountIncreaseRate4;
    private float salesAmountIncreaseRate3;
    private float salesAmountIncreaseRate2;
    private float salesAmountIncreaseRate1;
    private float salesAmountIncreaseRate;
    private double eps4;
    private double eps3;
    private double eps2;
    private double eps1;
    private double eps;
    private float epsIncreaseRate4;
    private float epsIncreaseRate3;
    private float epsIncreaseRate2;
    private float epsIncreaseRate1;
    private float epsIncreaseRate;
    private float roe4;
    private float roe3;
    private float roe2;
    private float roe1;
    private float roe;
    private double dps4;
    private double dps3;
    private double dps2;
    private double dps1;
    private double dps;
}
