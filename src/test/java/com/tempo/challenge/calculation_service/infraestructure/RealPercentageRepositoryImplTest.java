package com.tempo.challenge.calculation_service.infraestructure;

import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@SpringBootTest
class RealServiceIntegrationTest {

    @Autowired
    private PercentageRepository percentageRepository;

    @Test
    void when_callingRealService_then_returnsPercentage() {
        Mono<BigDecimal> result = percentageRepository.getCurrentPercentage();

        StepVerifier.create(result)
                .expectNextMatches(p -> p.compareTo(BigDecimal.ZERO) > 0)
                .verifyComplete();
    }
}
