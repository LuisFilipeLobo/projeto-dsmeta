package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.repositories.SalesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesSevice {
    @Autowired
    private SalesRepositories repo;

    public List<Sales> findSales() {
        return repo.findAll();
    }
}
