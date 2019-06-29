package com.example.stockhandling.stockhandling.service;

import com.example.stockhandling.stockhandling.domain.Stock;
import com.example.stockhandling.stockhandling.exception.OutdatedStockException;
import com.example.stockhandling.stockhandling.repository.StockRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public Stock create(Stock stock){

        if(stockRepository.existByProductId(stock.getProductId()) &&
                stockRepository.getLastByProductId(stock.getProductId()).getTimestamp()
                        .isAfter(stock.getTimestamp())){
            throw new OutdatedStockException();
        }

        return stockRepository.save(stock);
    }

    public String getLastByProductId(String productId){

        JSONObject responseJsonObj = new JSONObject();

        responseJsonObj.put("productId", productId);
        responseJsonObj.put("requestTimestamp", LocalDateTime.now());

        Stock stock =  stockRepository.getLastByProductId(productId);

        JSONObject stockJsonObj = new JSONObject();

        stockJsonObj.put("id", stock.getStockId());
        stockJsonObj.put("timestamp", stock.getTimestamp());
        stockJsonObj.put("quantiry", stock.getQuantity());

        responseJsonObj.put("stock", stockJsonObj);

        return responseJsonObj.toString();
    }
}
