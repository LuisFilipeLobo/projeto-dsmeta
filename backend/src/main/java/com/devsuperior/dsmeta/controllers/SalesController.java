package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.services.SalesSevice;
import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SalesController {
    @Autowired
    private SalesSevice service;
    @Autowired
    private SmsService smsService;

    @GetMapping("/sales")
    public Page<Sales> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return service.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void smsNotify(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
