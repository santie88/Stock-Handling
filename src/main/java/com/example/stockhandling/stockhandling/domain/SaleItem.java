package com.example.stockhandling.stockhandling.domain;

public class SaleItem {
    private String productId;
    private int Quantity;

    public SaleItem(String productId, int quantity) {
        this.productId = productId;
        Quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
