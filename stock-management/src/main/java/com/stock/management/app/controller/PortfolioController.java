package com.stock.management.app.controller;

import com.stock.management.app.ApiResponse;
import com.stock.management.app.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @RequestMapping(value = "/portfolio/list", method = RequestMethod.GET)
    public String getPortfolios(Model model) {
        model.addAttribute("list", portfolioService.getPortfolioList());
        return "/portfolio/list";
    }

    @PostMapping(value = "/portfolio/insert")
    @ResponseBody
    public ApiResponse insertPortfolio(@RequestParam String name) {
        try {
            portfolioService.portfolio(name);
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("{}", e);
            return ApiResponse.fail(e.getMessage());
        }
    }

    @RequestMapping("/portfolio/update")
    @ResponseBody
    public ApiResponse updatePortfolio(Model model, @RequestParam Long id, @RequestParam String name) {
        try {
            portfolioService.updatePortfolio(id, name);
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("{}", e);
            return ApiResponse.fail(e.getMessage());
        }
    }



}
