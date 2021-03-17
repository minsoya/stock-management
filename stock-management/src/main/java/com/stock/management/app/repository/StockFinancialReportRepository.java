package com.stock.management.app.repository;

import com.stock.management.app.entity.Stock;
import com.stock.management.app.entity.StockFinancialReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockFinancialReportRepository extends JpaRepository<StockFinancialReport, Long> {
    Optional<StockFinancialReport> findByStock(Stock stock);
}
