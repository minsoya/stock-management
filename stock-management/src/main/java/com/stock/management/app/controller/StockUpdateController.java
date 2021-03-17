package com.stock.management.app.controller;

import com.google.common.base.Preconditions;
import com.stock.management.app.StockManagementException;
import com.stock.management.app.dto.request.StockDto;
import com.stock.management.app.dto.request.StockFinancialReportDto;
import com.stock.management.app.dto.request.StockPriceDto;
import com.stock.management.app.entity.Stock;
import com.stock.management.app.entity.StockFinancialReport;
import com.stock.management.app.enums.ExceptionMessage;
import com.stock.management.app.enums.Market;
import com.stock.management.app.service.StockFinancialReportService;
import com.stock.management.app.service.StockPriceService;
import com.stock.management.app.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@Slf4j
public class StockUpdateController {

    @Autowired
    StockPriceService stockPriceService;
    @Autowired
    private StockService stockService;
    @Autowired
    private StockFinancialReportService stockFinancialReportService;

    @PostMapping(value = "/stock/price/insert")
    public String insertPrice(@RequestBody @Validated List<StockPriceDto> dtos) {
        Preconditions.checkState(dtos.stream().allMatch(x -> StringUtils.equals(x.getCode(), dtos.get(0).getCode())));
        stockPriceService.stockPrice(dtos);
        return "success";
    }

    @PostMapping(value = "/stock/financial/update")
    public String updateStock(@RequestBody @Validated List<StockFinancialReportDto> dtos) {
        stockFinancialReportService.stockFinancialReport(dtos);
        return "success";
    }

    @PostMapping(value = "/stock/insert")
    public String insertStock(@RequestBody @Validated StockDto dto) {
        stockService.stock(dto);
        return "success";
    }

}

//    @Transactional
//    public void update(StockDto dto) {
//        Stock stock = stockRepository.findByCodeAndMarket(dto.getCode(), Market.of(dto.getMarket())).orElseThrow(
//                () -> new StockManagementException(ExceptionMessage.STOCK_IN_MARKET_NOT_FOUND, dto.getCode(), dto.getMarket())
//        );
//
//        stock.setPrice(dto.getPrice());
//        stock.setDps(dto.getDps());
//        stock.setPer(dto.getPer());
//
//        log.info("Stock has been updated. {}:{}", stock.getCode(), stock.getName());
//    }
