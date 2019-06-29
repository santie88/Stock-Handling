package com.example.stockhandling.stockhandling.help;

import java.time.LocalDateTime;

public class LastMonth implements TimeStrategy {

    @Override
    public Boolean dateInsideRange(LocalDateTime saleDate, LocalDateTime now) {

        LocalDateTime lastMonthDate = now.minusMonths(1);

        return lastMonthDate.getYear() == saleDate.getYear()
                && lastMonthDate.getMonth() == saleDate.getMonth();
    }
}
