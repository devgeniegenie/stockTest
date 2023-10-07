package com.example.stocktest.Domain;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
public class Stock {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long quantity;

    @Version
    private Long version;

    public Stock(Long id) {
        this.id = id;
    }

    public Stock(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Stock() {

    }

    public Long getQuantity() {
        return quantity;
    }
    public void decrease(Long quantity) {
        if (this.quantity - quantity < 0) {
            throw new RuntimeException("재고는 0개 미만이 될 수 없습니다");
        }

        this.quantity = this.quantity - quantity;
    }
}
