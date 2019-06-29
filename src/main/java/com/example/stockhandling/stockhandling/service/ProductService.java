package com.example.stockhandling.stockhandling.service;

import com.example.stockhandling.stockhandling.domain.Stock;
import com.example.stockhandling.stockhandling.exception.TimeStrategyNotExistException;
import com.example.stockhandling.stockhandling.help.TimeStrategy;
import com.example.stockhandling.stockhandling.help.TimeStrategyFactory;
import com.example.stockhandling.stockhandling.repository.SaleRepository;
import com.example.stockhandling.stockhandling.repository.StockRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private StockRepository stockRepository;
    private SaleRepository saleRepository;

    public ProductService(StockRepository stockRepository, SaleRepository saleRepository) {
        this.stockRepository = stockRepository;
        this.saleRepository = saleRepository;
    }

    public String getStatics(String time){

        TimeStrategy timeStrategy = TimeStrategyFactory.getTimeStrategy(time);

        if(timeStrategy == null) throw new TimeStrategyNotExistException();

        LocalDateTime now = LocalDateTime.now();

        List<Stock> topAvailableProducts = stockRepository.getTopStocksInRange(now, timeStrategy);
        Map<String, Integer> topSellingProducts = saleRepository.getTopSalesItemsInRange(now, timeStrategy);

        List<JSONObject> topSellingProductsJsonObj = new ArrayList<>();

        topSellingProducts.forEach((k, v) -> {
            JSONObject topSaleProduct = new JSONObject();

            topSaleProduct.put("productId", k);
            topSaleProduct.put("itemsSold", v);

            topSellingProductsJsonObj.add(topSaleProduct);
        });

        JSONObject responseJsonObj = new JSONObject();

        responseJsonObj.put("requestTimestamp", LocalDateTime.now());
        responseJsonObj.put("range", time);
        responseJsonObj.put("topAvailableProducts", topAvailableProducts);
        responseJsonObj.put("topSellingProducts", topSellingProductsJsonObj);

        return responseJsonObj.toString();
    }
}
