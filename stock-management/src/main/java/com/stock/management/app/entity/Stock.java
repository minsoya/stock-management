package com.stock.management.app.entity;

import com.stock.management.app.BaseEntity;
import com.stock.management.app.enums.Market;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "stock")
public class Stock extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String code;
    @NonNull
    private String name;
    @NonNull
    private Market market;

    private double price;

    private double dividend1;
    private double dividend2;
    private double dividend3;
    private double dividend4;
    private double dividend5;
    private double dividend6;
    private double dividend7;
    private double dividend8;
    private double dividend9;
    private double dividend10;
    private double dividend11;
    private double dividend12;

    private Long volume;
}
