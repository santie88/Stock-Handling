package com.example.stockhandling.stockhandling.repository;

import com.example.stockhandling.stockhandling.domain.Sale;
import com.example.stockhandling.stockhandling.domain.SaleItem;
import com.example.stockhandling.stockhandling.help.TimeStrategy;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

// Since it's an InMemory solution implements logic here to filter the data simulating a query builder mechanism
@Repository
public class SaleRepository extends BaseRepository<Sale>{

    public Map<String, Integer> getSalesItemsInRange(LocalDateTime now, TimeStrategy timeStrategy){
        return this.list
                .stream()
                .filter(sale -> timeStrategy.dateInsideRange(sale.getTimestamp(), now))
                .map(sale -> sale.getSaleItems())
                .flatMap(saleItems -> saleItems.stream())
                .collect(Collectors.groupingBy(SaleItem::getProductId, Collectors.summingInt(SaleItem::getQuantity)));
    }

    public Map<String, Integer> getTopSalesItemsInRange(LocalDateTime now, TimeStrategy timeStrategy){
        return getSalesItemsInRange(now, timeStrategy)
                .entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
