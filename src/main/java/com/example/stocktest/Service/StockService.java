package com.example.stocktest.Service;

import com.example.stocktest.Domain.Stock;
import com.example.stocktest.Repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW) //자식 트렌젝션과 별도로 실행되어야 하기 때문에 프로퍼게이션 설정
    public void decrease(Long id, Long quantity) {
        // Stock 조회
        Stock stock = stockRepository.findById(id).orElseThrow();
        // 재고 감소
        stock.decrease(quantity);
        // 갱신된 값 저장
        stockRepository.saveAndFlush(stock);

    }
}
