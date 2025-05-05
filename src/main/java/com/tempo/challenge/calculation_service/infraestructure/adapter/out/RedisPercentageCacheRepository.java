package com.tempo.challenge.calculation_service.infraestructure.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Duration;

@Repository
@RequiredArgsConstructor
public class RedisPercentageCacheRepository {

    private final ReactiveRedisTemplate<String, BigDecimal> redisTemplate;
    private static final String CACHE_KEY = "current-percentage";

    public Mono<BigDecimal> get() {
        return redisTemplate.opsForValue().get(CACHE_KEY);
    }

    public Mono<Void> save(BigDecimal percentage) {
        return redisTemplate.opsForValue()
                .set(CACHE_KEY, percentage, Duration.ofMinutes(30))
                .then();
    }
}