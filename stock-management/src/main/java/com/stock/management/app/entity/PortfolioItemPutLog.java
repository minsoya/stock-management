package com.stock.management.app.entity;

import com.stock.management.app.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "portfolio_item_put_log")
public class PortfolioItemPutLog extends BaseEntity {
    @Id
    @GeneratedValue
    private int id;

    @JoinColumn(name = "portfolioItemId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PortfolioItem portfolioItem;

    @Enumerated
    private WorkType workType;

    public enum  WorkType {
        DEPOSIT("입금"),
        WITHDRAWL("출금"),
        DIVIDEND("배당");

        private String text;

        WorkType(String text){
            this.text = text;
        }
    }

    private Integer putQuantity;

    private Double putPriceSum;

}
