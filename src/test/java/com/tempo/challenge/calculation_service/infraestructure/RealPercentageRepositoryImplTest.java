package com.tempo.challenge.calculation_service.infraestructure;

import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import com.tempo.challenge.calculation_service.infraestructure.adapter.out.ExternalPercentageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@SpringBootTest
class RealPercentageRepositoryImplTest {

    @Autowired
    private ExternalPercentageClient externalPercentageClient;

    @Test
    void when_callingRealService_then_returnsPercentage() {
        Mono<BigDecimal> result = externalPercentageClient.fetchPercentage();

        StepVerifier.create(result)
                .expectNextMatches(p -> p.compareTo(BigDecimal.ZERO) > 0)
                .verifyComplete();
    }
}
