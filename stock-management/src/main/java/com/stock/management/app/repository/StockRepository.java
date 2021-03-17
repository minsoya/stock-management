package com.stock.management.app.repository;

import com.stock.management.app.entity.Stock;
import com.stock.management.app.enums.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByCodeAndMarket(String code, Market market);
    Optional<Stock> findByCode(String code);
}
