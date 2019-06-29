package com.example.stockhandling.stockhandling.controller;

import com.example.stockhandling.stockhandling.domain.Stock;
import com.example.stockhandling.stockhandling.exception.OutdatedStockException;
import com.example.stockhandling.stockhandling.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED )
    public Stock updateStock(@RequestBody Stock stock) {
        return stockService.create(stock);
    }

    @GetMapping()
    public String getCurrentStock(@RequestParam("productId") String productId){
        return stockService.getLastByProductId(productId);
    }

    @ExceptionHandler(value = { OutdatedStockException.class })
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public String handleNoContentFailedException(RuntimeException ex){
        return ex.getMessage();
    }

}
