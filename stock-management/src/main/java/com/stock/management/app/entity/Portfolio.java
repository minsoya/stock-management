package com.stock.management.app.entity;

import com.stock.management.app.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "portfolio")
public class Portfolio extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
}
