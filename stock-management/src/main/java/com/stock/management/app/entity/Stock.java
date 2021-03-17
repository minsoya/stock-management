package com.stock.management.app.entity;

import com.stock.management.app.BaseEntity;
import com.stock.management.app.enums.Market;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "stock")
public class Stock extends BaseEntity {
    @Id
    @GeneratedValue
    private int id;
    @NonNull
    private String code;
    @NonNull
    private String name;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Market market;

}
