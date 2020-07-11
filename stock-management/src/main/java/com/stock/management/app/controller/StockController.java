package com.stock.management.app.controller;

import com.stock.management.app.ApiResponse;
import com.stock.management.app.dto.request.StockDto;
import com.stock.management.app.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping(value = "/stock/list", method = RequestMethod.GET)
    public String getStocks(Model model) {
        model.addAttribute("list", stockService.getStockList());
        return "/stock/list";
    }

    @PostMapping(value = "/stock/insert")
    @ResponseBody
    public ApiResponse insertStock(@RequestBody @Validated StockDto dto) {
        try {
            stockService.stock(dto);
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("{}", e);
            return ApiResponse.fail(e.getMessage());
        }
    }

}
