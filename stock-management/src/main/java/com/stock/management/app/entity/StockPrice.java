package com.stock.management.app.entity;

import com.stock.management.app.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "stock_price")
public class StockPrice extends BaseEntity {
    @Id
    @GeneratedValue
    private int id;

    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    @NonNull
    private String date;

    private double high;
    private double low;
    private double open;
    private double close;

    private long volume;

}
