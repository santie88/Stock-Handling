package com.example.stockhandling.stockhandling.bootstrap;

import com.example.stockhandling.stockhandling.domain.Sale;
import com.example.stockhandling.stockhandling.domain.SaleItem;
import com.example.stockhandling.stockhandling.domain.Stock;
import com.example.stockhandling.stockhandling.service.SaleService;
import com.example.stockhandling.stockhandling.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

// Just a simple bootstrap to populate some records
@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    private StockService stockService;
    private SaleService saleService;

    @Autowired
    public void setStockService(StockService stockService, SaleService saleService){
        this.stockService = stockService;
        this.saleService = saleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        LocalDateTime date = LocalDateTime.now();
        Stock stock1 = new Stock("001", "prod-1", date, 100);
        stockService.create(stock1);

        SaleItem saleItem1 = new SaleItem("prod-1", 100);
        Sale sale1 = new Sale(1, date, Arrays.asList(saleItem1));
        saleService.create(sale1);

        date = date.plusSeconds(1);
        Stock stock2 = new Stock("002", "prod-2", date, 200);
        stockService.create(stock2);

        SaleItem saleItem2 = new SaleItem("prod-2", 100);
        Sale sale2 = new Sale(1, date, Arrays.asList(saleItem2));
        saleService.create(sale2);

        date = date.plusSeconds(1);
        Stock stock3 = new Stock("003", "prod-3", date, 300);
        stockService.create(stock3);

        SaleItem saleItem3 = new SaleItem("prod-3", 100);
        Sale sale3 = new Sale(3, date, Arrays.asList(saleItem3));
        saleService.create(sale3);

        date = date.minusMonths(1);
        Stock stock4 = new Stock("004", "prod-4", date, 100);
        stockService.create(stock4);

        SaleItem saleItem4 = new SaleItem("prod-4", 100);
        Sale sale4 = new Sale(4, date, Arrays.asList(saleItem4));
        saleService.create(sale4);

        date = date.plusSeconds(1);
        Stock stock5 = new Stock("005", "prod-5", date, 200);
        stockService.create(stock5);

        SaleItem saleItem5 = new SaleItem("prod-5", 100);
        Sale sale5 = new Sale(5, date, Arrays.asList(saleItem5));
        saleService.create(sale5);

        date = date.plusSeconds(1);
        Stock stock6 = new Stock("006", "prod-6", date, 300);
        stockService.create(stock6);

        SaleItem saleItem6 = new SaleItem("prod-6", 100);
        Sale sale6 = new Sale(6, date, Arrays.asList(saleItem6));
        saleService.create(sale6);
    }

}
