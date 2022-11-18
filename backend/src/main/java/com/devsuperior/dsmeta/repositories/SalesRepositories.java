package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepositories extends JpaRepository<Sales, Long> {
}
