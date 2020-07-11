package com.stock.management.app.controller;

import com.google.common.base.Preconditions;
import com.stock.management.app.ApiResponse;
import com.stock.management.app.dto.request.PortfolioItemDto;
import com.stock.management.app.service.PortfolioItemService;
import com.stock.management.app.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PortfolioItemController {

    @Autowired
    PortfolioService portfolioService;
    @Autowired
    PortfolioItemService portfolioItemService;


    @RequestMapping(value = "/portfolio/item/list/{portfolioId}", method = RequestMethod.GET)
    public String getPortfolioItems(Model model, @PathVariable Long portfolioId) {
        model.addAttribute("portfolio", portfolioService.getPortfolio(portfolioId));
        model.addAttribute("list", portfolioItemService.getPortfolioItemList(portfolioId));
        return "/portfolio/item/list";
    }

    @ResponseBody
    @RequestMapping("/portfolio/item/insert")
    public ApiResponse portfolioItem(@RequestBody PortfolioItemDto dto) {
        try {
            Preconditions.checkNotNull(dto.getPortfolioId());
            Preconditions.checkNotNull(dto.getPrice());
            Preconditions.checkNotNull(dto.getQuantity());
            Preconditions.checkNotNull(dto.getStockId());

            portfolioItemService.portfolioItem(dto);
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("{}", e);
            return ApiResponse.fail(e.getMessage());
        }
    }

}
