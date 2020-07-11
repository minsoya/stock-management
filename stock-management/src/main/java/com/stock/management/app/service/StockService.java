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
import java.util.Map;

@Service
@Slf4j
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStockList(){
        return stockRepository.findAll();
    }

    @Transactional
    public void stock(StockDto dto) {
        stockRepository.findByCodeAndMarket(dto.getCode(), Market.of(dto.getMarket())).ifPresent(
                (s) -> { throw new StockManagementException(ExceptionMessage.DUPLICATE_STOCK_FOUND, s.getCode(), s.getMarket().getText()); }
        );

        Stock tempStock = new Stock();
        tempStock.setCode(dto.getCode());
        tempStock.setName(dto.getName());
        tempStock.setMarket(Market.of(dto.getMarket()));
        tempStock.setPrice(dto.getPrice());

        Map<Integer, Double> map = dto.getDividendMap();
        map.forEach((k, v)->{
            switch (k) {
                case 1 -> tempStock.setDividend1(v);
                case 2 -> tempStock.setDividend2(v);
                case 3 -> tempStock.setDividend3(v);
                case 4 -> tempStock.setDividend4(v);
                case 5 -> tempStock.setDividend5(v);
                case 6 -> tempStock.setDividend6(v);
                case 7 -> tempStock.setDividend7(v);
                case 8 -> tempStock.setDividend8(v);
                case 9 -> tempStock.setDividend9(v);
                case 10 -> tempStock.setDividend10(v);
                case 11 -> tempStock.setDividend11(v);
                case 12 -> tempStock.setDividend12(v);
            }
        });
        tempStock.setVolume(dto.getVolume());
        Stock stock = stockRepository.save(tempStock);

        log.info("New stock has been created. {}", stock);
    }

    public Stock getStock(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.STOCK_NOT_FOUND, id.toString()));
        return stock;
    }

}
