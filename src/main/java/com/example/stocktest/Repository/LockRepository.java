package com.example.stocktest.Repository;

import com.example.stocktest.Domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 같은 데이터 소스를 사용하면 커넥션 풀이 부족해지는 현상이 생길 수 있으므로
// 데이터 소스르 분리해서 사용. 실무에서는 별도의 JDBC사용
public interface LockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT get_lock(:key, 3000)", nativeQuery = true)
    void getLock(String key);

    @Query(value = "SELECT release_lock(:key)", nativeQuery = true)
    void releaseLock(String key);
}
