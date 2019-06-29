package com.example.stockhandling.stockhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StockhandlingApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(StockhandlingApplication.class, args);
	}

}
