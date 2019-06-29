package com.example.stockhandling.stockhandling.service;

import com.example.stockhandling.stockhandling.domain.Sale;
import com.example.stockhandling.stockhandling.repository.SaleRepository;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    public Sale create(Sale sale){

        return saleRepository.save(sale);
    }
}
