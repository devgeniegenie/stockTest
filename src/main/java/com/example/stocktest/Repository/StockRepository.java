package com.example.stocktest.Repository;

import com.example.stocktest.Domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
