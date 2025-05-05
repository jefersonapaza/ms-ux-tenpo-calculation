package com.tempo.challenge.calculation_service.infraestructure;

import com.tempo.challenge.calculation_service.infraestructure.adapter.out.RedisPercentageCacheRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RedisPercentageCacheRepositoryTest {

    private RedisPercentageCacheRepository redisRepository;

    @Mock
    private ReactiveRedisTemplate<String, BigDecimal> redisTemplate;

    @Mock
    private ReactiveValueOperations<String, BigDecimal> valueOperations;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        redisRepository = new RedisPercentageCacheRepository(redisTemplate);
    }

    @Test
    void given_percentage_when_save_then_storeInRedis() {
        // Arrange
        BigDecimal percentage = BigDecimal.valueOf(25);
        when(valueOperations.set(eq("current-percentage"), eq(percentage), any(Duration.class)))
                .thenReturn(Mono.just(true));

        // Act & Assert
        StepVerifier.create(redisRepository.save(percentage))
                .verifyComplete();

        verify(valueOperations).set(eq("current-percentage"), eq(percentage), any(Duration.class));
    }

    @Test
    void given_valueInCache_when_get_then_returnValue() {
        // Arrange
        BigDecimal expected = BigDecimal.valueOf(15);
        when(valueOperations.get("current-percentage")).thenReturn(Mono.just(expected));

        // Act
        Mono<BigDecimal> result = redisRepository.get();

        // Assert
        StepVerifier.create(result)
                .expectNext(expected)
                .verifyComplete();
    }

    @Test
    void given_cacheMiss_when_get_then_returnEmptyMono() {
        // Arrange
        when(valueOperations.get("current-percentage")).thenReturn(Mono.empty());

        // Act
        Mono<BigDecimal> result = redisRepository.get();

        // Assert
        StepVerifier.create(result)
                .verifyComplete();
    }
}