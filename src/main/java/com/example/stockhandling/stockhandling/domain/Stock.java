package com.example.stockhandling.stockhandling.domain;

import java.time.LocalDateTime;

public class Stock {
    private String stockId;
    private String productId;
    private LocalDateTime timestamp;
    private int Quantity;

    public Stock(String stockId, String productId, LocalDateTime timestamp, int quantity) {
        this.stockId = stockId;
        this.productId = productId;
        this.timestamp = timestamp;
        Quantity = quantity;
    }

    public Stock() {
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
