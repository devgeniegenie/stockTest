package com.example.stocktest.Service;

import com.example.stocktest.Domain.Stock;
import com.example.stocktest.Repository.StockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PessimisticLockStockService {

    private final StockRepository stockRepository;

    public PessimisticLockStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdPessimisticLock(id);

        stock.decrease(quantity);

        stockRepository.save(stock);
    }
}
