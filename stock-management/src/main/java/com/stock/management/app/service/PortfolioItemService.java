package com.stock.management.app.service;

import com.stock.management.app.StockManagementException;
import com.stock.management.app.dto.request.PortfolioItemDto;
import com.stock.management.app.entity.Portfolio;
import com.stock.management.app.entity.PortfolioItem;
import com.stock.management.app.entity.PortfolioItemPutLog;
import com.stock.management.app.entity.Stock;
import com.stock.management.app.enums.ExceptionMessage;
import com.stock.management.app.repository.PortfolioItemRepository;
import com.stock.management.app.repository.PortfolioRepository;
import com.stock.management.app.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class PortfolioItemService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private PortfolioItemRepository portfolioItemRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private PortfolioItemPutLogService portfolioItemPutLogService;

    public List<PortfolioItem> getPortfolioItemList(Long portfolioId){
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.PORTFOLIO_NOT_FOUND, String.valueOf(portfolioId)));

        return portfolioItemRepository.findByPortfolio(portfolio);
    }

    @Transactional
    public void portfolioItem(PortfolioItemDto dto) {
        Portfolio portfolio = portfolioRepository.findById(dto.getPortfolioId())
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.PORTFOLIO_NOT_FOUND, dto.getPortfolioId().toString()));
        Stock stock = stockRepository.findById(dto.getStockId())
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.STOCK_NOT_FOUND, dto.getStockId().toString()));

        portfolioItemRepository.findByStockAndPortfolio(stock, portfolio).ifPresentOrElse(
                (portfolioItem) -> updatePortfolioItem(portfolioItem, dto.getQuantity(), dto.getPrice()),
                () -> createPortfolioItem(portfolio, stock, dto.getQuantity(), dto.getPrice())
        );
    }

    public void createPortfolioItem(Portfolio portfolio, Stock stock, int quantity, Double price) {
       final double purchasePrice = price * quantity;

        PortfolioItem tempPortfolioItem = new PortfolioItem();
        tempPortfolioItem.setStock(stock);
        tempPortfolioItem.setQuantity(quantity);
        tempPortfolioItem.setPortfolio(portfolio);
        tempPortfolioItem.setPurchasePriceSum(purchasePrice);

        PortfolioItem portfolioItem = portfolioItemRepository.save(tempPortfolioItem);
        portfolioItemPutLogService.saveLog(portfolioItem, quantity, purchasePrice);

        log.info("New portfolioItem has been created. id:{}, stockId:{}, quantity:{}, portfolio:{}, purchasePriceSum:{}",
                portfolioItem.getId(), portfolioItem.getStock().getId(), portfolioItem.getQuantity(), portfolioItem.getPortfolio(), portfolioItem.getPurchasePriceSum());

    }

    public void updatePortfolioItem(PortfolioItem portfolioItem, int quantity, Double price) {
        Double purchasePrice = quantity * price;
        portfolioItem.setPurchasePriceSum(portfolioItem.getPurchasePriceSum() + purchasePrice);
        portfolioItemRepository.save(portfolioItem);
        portfolioItemPutLogService.saveLog(portfolioItem, quantity, purchasePrice);
    }
}
