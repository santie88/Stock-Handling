package com.example.stockhandling.stockhandling.help;

import java.time.LocalDateTime;

public class Today implements TimeStrategy {
    @Override
    public Boolean dateInsideRange(LocalDateTime saleDate, LocalDateTime now) {

        return saleDate.toLocalDate().isEqual(now.toLocalDate())
                && saleDate.isBefore(now);
    }
}
