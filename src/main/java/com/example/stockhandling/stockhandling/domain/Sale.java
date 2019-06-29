package com.example.stockhandling.stockhandling.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private int saleId;
    private LocalDateTime timestamp;
    List<SaleItem> saleItems;

    public Sale(int saleId, LocalDateTime timestamp, List<SaleItem> saleItems) {
        this.saleId = saleId;
        this.timestamp = timestamp;
        this.saleItems = saleItems;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }
}
