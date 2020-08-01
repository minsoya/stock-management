package com.stock.management.app.repository;

import com.stock.management.app.entity.Stock;
import com.stock.management.app.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
    List<StockPrice> findByStock(Stock stock);
    Optional<StockPrice> findByStockAndDate(Stock stock, String date);
    Optional<StockPrice> findTopByStockOrderByDateDesc(Stock stock);
}
