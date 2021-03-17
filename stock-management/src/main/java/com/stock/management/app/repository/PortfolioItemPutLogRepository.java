package com.stock.management.app.repository;

import com.stock.management.app.entity.PortfolioItemPutLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PortfolioItemPutLogRepository extends JpaRepository<PortfolioItemPutLog, Long> {
}
