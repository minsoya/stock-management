package com.stock.management.app.repository;

import com.stock.management.app.entity.Portfolio;
import com.stock.management.app.entity.PortfolioItem;
import com.stock.management.app.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    Optional<PortfolioItem> findByStockAndPortfolio(Stock stock, Portfolio portfolio);
    List<PortfolioItem> findByPortfolio(Portfolio portfolio);
}
