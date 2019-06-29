package com.example.stockhandling.stockhandling.exception;

public class OutdatedStockException extends RuntimeException {
    public OutdatedStockException() {
        super("Outdated stock, because a newer stock was processed first");
    }
}
