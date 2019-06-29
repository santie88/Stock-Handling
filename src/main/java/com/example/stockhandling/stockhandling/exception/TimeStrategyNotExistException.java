package com.example.stockhandling.stockhandling.exception;

public class TimeStrategyNotExistException extends RuntimeException {
    public TimeStrategyNotExistException(){
        super("Time range does not exist");
    }
}
