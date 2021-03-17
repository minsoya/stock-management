package com.stock.management.app.service;

import com.stock.management.app.StockManagementException;
import com.stock.management.app.dto.request.StockDto;
import com.stock.management.app.dto.request.StockPriceDto;
import com.stock.management.app.entity.Stock;
import com.stock.management.app.entity.StockPrice;
import com.stock.management.app.enums.ExceptionMessage;
import com.stock.management.app.enums.Market;
import com.stock.management.app.repository.StockPriceRepository;
import com.stock.management.app.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StockPriceService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Transactional
    public void stockPrice(List<StockPriceDto> dtoList) {
        List<StockPrice> stockPriceList = new ArrayList<>();
        Stock stock = stockRepository.findByCodeAndMarket(dtoList.get(0).getCode(), Market.of(dtoList.get(0).getMarket()))
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.STOCK_IN_MARKET_NOT_FOUND,
                        dtoList.get(0).getCode(), dtoList.get(0).getMarket()));

        for (StockPriceDto dto : dtoList) {
            if (stockPriceRepository.findByStockAndDate(stock, dto.getDate()).isPresent()){
                continue;
            }

            StockPrice tempStockPrice = new StockPrice();

            tempStockPrice.setStock(stock);
            tempStockPrice.setDate(dto.getDate());
            tempStockPrice.setHigh(dto.getHigh());
            tempStockPrice.setLow(dto.getLow());
            tempStockPrice.setOpen(dto.getOpen());
            tempStockPrice.setClose(dto.getClose());
            tempStockPrice.setVolume(dto.getVolume());

            stockPriceList.add(tempStockPrice);
        }

        if (CollectionUtils.isNotEmpty(stockPriceList)){
            stockPriceRepository.saveAll(stockPriceList);
            log.info("New stockPrice has been created. {}", stockPriceList);
        }
    }

}
