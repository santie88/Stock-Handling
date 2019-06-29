package com.example.stockhandling.stockhandling.repository;

import com.example.stockhandling.stockhandling.domain.Stock;
import com.example.stockhandling.stockhandling.exception.OutdatedStockException;
import com.example.stockhandling.stockhandling.help.TimeStrategy;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

// Since it's an InMemory solution implements logic here to filter the data simulating a query builder mechanism
@Repository
public class StockRepository extends BaseRepository<Stock>{

    public Boolean existByProductId(String productId){
        return list.stream()
                    .anyMatch(p -> p.getProductId().equals(productId));
    }

    public Stock getLastByProductId(String productId){
        return list.stream()
                    .filter(s -> s.getProductId().equals(productId))
                    .max(Comparator.comparing(Stock::getTimestamp))
                    .get();
    }

    public List<Stock> getTopStocksInRange(LocalDateTime now, TimeStrategy timeStrategy){
        return this.list
                .stream()
                .filter(stock -> timeStrategy.dateInsideRange(stock.getTimestamp(), now))
                .sorted(Comparator.comparingInt(Stock::getQuantity).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }
}
