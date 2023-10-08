package com.example.stocktest.facade;

import com.example.stocktest.Repository.LockRepository;
import com.example.stocktest.Service.StockService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NameLockStockFacade {

    private final LockRepository lockRepository;

    private final StockService stockService;

    public NameLockStockFacade(LockRepository lockRepository, StockService stockService) {
        this.lockRepository = lockRepository;
        this.stockService = stockService;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        try {
            lockRepository.getLock(id.toString());
            stockService.decrease(id, quantity);
        } finally {
            lockRepository.releaseLock(id.toString());
        }

    }
}
