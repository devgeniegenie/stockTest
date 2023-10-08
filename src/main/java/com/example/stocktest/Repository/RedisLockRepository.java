package com.example.stocktest.Repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisLockRepository {

    private RedisTemplate<String, String> redisTemplate;

    public RedisLockRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Boolean lock(Long key) {
        return redisTemplate
                .opsForValue()
                .setIfAbsent(getGenerateKey(key), "lock", Duration.ofMillis(3_000));
    }

    public boolean unlock(Long key) {
        return redisTemplate.delete(getGenerateKey(key));
    }

    private String getGenerateKey(Long key) {
        return key.toString();
    }
}
