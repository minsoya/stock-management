package com.stock.management.app.service;

import com.stock.management.app.StockManagementException;
import com.stock.management.app.dto.request.StockFinancialReportDto;
import com.stock.management.app.dto.request.StockPriceDto;
import com.stock.management.app.entity.Stock;
import com.stock.management.app.entity.StockFinancialReport;
import com.stock.management.app.entity.StockPrice;
import com.stock.management.app.enums.ExceptionMessage;
import com.stock.management.app.enums.Market;
import com.stock.management.app.repository.StockFinancialReportRepository;
import com.stock.management.app.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StockFinancialReportService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockFinancialReportRepository stockFinancialReportRepository;

    @Transactional
    public void stockFinancialReport(List<StockFinancialReportDto> dtoList) {
        List<StockFinancialReport> stockFinancialReportList = new ArrayList<>();
        Stock stock = stockRepository.findByCodeAndMarket(dtoList.get(0).getCode(), Market.of(dtoList.get(0).getMarket()))
                .orElseThrow(() -> new StockManagementException(ExceptionMessage.STOCK_IN_MARKET_NOT_FOUND,
                        dtoList.get(0).getCode(), dtoList.get(0).getMarket()));

        for (StockFinancialReportDto dto : dtoList) {

            StockFinancialReport tempReport = stockFinancialReportRepository.findByStock(stock)
                    .orElse(new StockFinancialReport());

            if (StringUtils.equals(dto.getUpdateMonth(), tempReport.getUpdateMonth())) {
                continue;
            }

            tempReport.setStock(stock);
            tempReport.setUpdateMonth(dto.getUpdateMonth());
            tempReport.setPastPer(dto.getPastPer());
            tempReport.setPer(dto.getPer());
            tempReport.setSalesAmountIncreaseRate4(dto.getSalesAmountIncreaseRate4());
            tempReport.setSalesAmountIncreaseRate3(dto.getSalesAmountIncreaseRate3());
            tempReport.setSalesAmountIncreaseRate2(dto.getSalesAmountIncreaseRate2());
            tempReport.setSalesAmountIncreaseRate1(dto.getSalesAmountIncreaseRate1());
            tempReport.setSalesAmountIncreaseRate(dto.getSalesAmountIncreaseRate());
            tempReport.setEps4(dto.getEps4());
            tempReport.setEps3(dto.getEps3());
            tempReport.setEps2(dto.getEps2());
            tempReport.setEps1(dto.getEps1());
            tempReport.setEps(dto.getEps());
            tempReport.setEpsIncreaseRate4(dto.getEpsIncreaseRate4());
            tempReport.setEpsIncreaseRate3(dto.getEpsIncreaseRate3());
            tempReport.setEpsIncreaseRate2(dto.getEpsIncreaseRate2());
            tempReport.setEpsIncreaseRate1(dto.getEpsIncreaseRate1());
            tempReport.setEpsIncreaseRate(dto.getEpsIncreaseRate());
            tempReport.setRoe4(dto.getRoe4());
            tempReport.setRoe3(dto.getRoe3());
            tempReport.setRoe2(dto.getRoe2());
            tempReport.setRoe1(dto.getRoe1());
            tempReport.setRoe(dto.getRoe());
            tempReport.setDps4(dto.getDps4());
            tempReport.setDps3(dto.getDps3());
            tempReport.setDps2(dto.getDps2());
            tempReport.setDps1(dto.getDps1());
            tempReport.setDps(dto.getDps());

            stockFinancialReportList.add(tempReport);
        }

        if (CollectionUtils.isNotEmpty(stockFinancialReportList)) {
            stockFinancialReportRepository.saveAll(stockFinancialReportList);
            log.info("New stockPrice has been created. {}", stockFinancialReportList);
        }
    }

}
