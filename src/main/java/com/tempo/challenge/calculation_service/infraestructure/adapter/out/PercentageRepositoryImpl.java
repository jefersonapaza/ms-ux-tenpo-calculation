package com.tempo.challenge.calculation_service.infraestructure.adapter.out;

import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Repository
public class PercentageRepositoryImpl implements PercentageRepository {

    private final RedisPercentageCacheRepository redisCache;
    private final ExternalPercentageClient externalClient;

    @Override
    public Mono<BigDecimal> getCurrentPercentage() {
        return redisCache.get()
                .switchIfEmpty(
                        externalClient.fetchPercentage()
                                .flatMap(p -> redisCache.save(p).thenReturn(p))
                );
    }
}
