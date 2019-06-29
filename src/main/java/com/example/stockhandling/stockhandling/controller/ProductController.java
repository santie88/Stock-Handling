package com.example.stockhandling.stockhandling.controller;

import com.example.stockhandling.stockhandling.exception.TimeStrategyNotExistException;
import com.example.stockhandling.stockhandling.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/statics")
    public String getStatics(@RequestParam("time") String time){
        return productService.getStatics(time);
    }

    @ExceptionHandler(value = { TimeStrategyNotExistException.class })
    @ResponseStatus( HttpStatus.BAD_REQUEST)
    public String handleWrongInputException(RuntimeException ex){
        return ex.getMessage();
    }
}
