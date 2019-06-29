package com.example.stockhandling.stockhandling.help;

import java.time.LocalDateTime;

public interface TimeStrategy {
    Boolean dateInsideRange(LocalDateTime saleDate, LocalDateTime now);
}
