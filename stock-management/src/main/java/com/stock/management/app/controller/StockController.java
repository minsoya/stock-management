package com.stock.management.app.controller;

import com.stock.management.app.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping(value = "/stock/list", method = RequestMethod.GET)
    public String getStocks(Model model) {
        model.addAttribute("list", stockService.getStockList());
        return "/stock/list";
    }

}
