package com.stock.management.app.dto.request;

import lombok.*;


@Data
public class StockFinancialReportDto {

    private String code;
    private String market;
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
