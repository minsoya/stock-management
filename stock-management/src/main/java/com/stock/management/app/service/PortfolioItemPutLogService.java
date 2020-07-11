package com.stock.management.app.service;

import com.stock.management.app.entity.PortfolioItem;
import com.stock.management.app.entity.PortfolioItemPutLog;
import com.stock.management.app.repository.PortfolioItemPutLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class PortfolioItemPutLogService {

    @Autowired
    private PortfolioItemPutLogRepository portfolioItemPutLogRepository;

    @Transactional
    public void saveLog(PortfolioItem portfolioItem, Integer quantity, Double priceSum){
        PortfolioItemPutLog.WorkType workType;
        if (quantity > 0 ){
            workType = PortfolioItemPutLog.WorkType.DEPOSIT;
        } else if (quantity < 0){
            workType = PortfolioItemPutLog.WorkType.WITHDRAWL;
        } else {
            workType = PortfolioItemPutLog.WorkType.DIVIDEND;
        }

        PortfolioItemPutLog log = new PortfolioItemPutLog();
        log.setPortfolioItem(portfolioItem);
        log.setWorkType(workType);
        log.setPutQuantity(quantity);
        log.setPutPriceSum(priceSum);
        portfolioItemPutLogRepository.save(log);
    }
}
