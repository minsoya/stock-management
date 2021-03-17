package com.stock.management.app.service;

import com.stock.management.app.StockManagementException;
import com.stock.management.app.dto.request.StockDto;
import com.stock.management.app.entity.Stock;
import com.stock.management.app.enums.ExceptionMessage;
import com.stock.management.app.enums.Market;
import com.stock.management.app.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStockList() {
        return stockRepository.findAll();
    }

    @Transactional
    public void stock(StockDto dto) {
        stockRepository.findByCodeAndMarket(dto.getCode(), Market.of(dto.getMarket())).ifPresent(
                (s) -> {
                    throw new StockManagementException(ExceptionMessage.DUPLICATE_STOCK_FOUND, s.getCode(), s.getMarket().getText());
                }
        );

        Stock tempStock = new Stock();
        tempStock.setCode(dto.getCode());
        tempStock.setName(dto.getName());
        tempStock.setMarket(Market.of(dto.getMarket()));

        Stock stock = stockRepository.save(tempStock);

        log.info("New stock has been created. {}", stock);
    }


    public Stock getStock(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.STOCK_NOT_FOUND, id.toString()));
        return stock;
    }

}
