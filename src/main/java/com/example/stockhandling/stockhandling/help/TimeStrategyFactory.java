package com.example.stockhandling.stockhandling.help;

public class TimeStrategyFactory {

    public static TimeStrategy getTimeStrategy(String timeStrategy){
        if(timeStrategy == null){
            return null;
        }
        if(timeStrategy.equalsIgnoreCase("today")){
            return new Today();

        } else if(timeStrategy.equalsIgnoreCase("lastMonth")){
            return new LastMonth();

        }

        return null;
    }
}
