package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.repositories.SalesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SalesSevice {
    @Autowired
    private SalesRepositories repo;

    public Page<Sales> findSales(String minDate, String maxDate, Pageable pageable) {

        // Criar variável com dia atual
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        // Converter as datas
        LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return repo.findSales(min, max, pageable);
    }
}
