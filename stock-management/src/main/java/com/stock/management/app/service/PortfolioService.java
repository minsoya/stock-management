package com.stock.management.app.service;

import com.google.common.base.Preconditions;
import com.stock.management.app.StockManagementException;
import com.stock.management.app.entity.Portfolio;
import com.stock.management.app.enums.ExceptionMessage;
import com.stock.management.app.repository.PortfolioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Transactional
    public void portfolio(String name) {
        Preconditions.checkNotNull(name, ExceptionMessage.PARAMETER_IS_NULL.getMessage(), "name");

        Portfolio tempPortfolio = new Portfolio();
        tempPortfolio.setName(name);
        Portfolio portfolio = portfolioRepository.save(tempPortfolio);
        log.info("New portfolio has been created. id:{}, name:{}", portfolio.getId(), portfolio.getName());
    }

    public Portfolio getPortfolio(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.PORTFOLIO_NOT_FOUND, id.toString()));
        return portfolio;
    }

    public List<Portfolio> getPortfolioList(){
        return portfolioRepository.findAll();
    }

    @Transactional
    public void updatePortfolio(Long id, String name) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.PORTFOLIO_NOT_FOUND, id.toString()));
        portfolio.setName(name);
    }

}
