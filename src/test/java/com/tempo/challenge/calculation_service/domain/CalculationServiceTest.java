package com.tempo.challenge.calculation_service.domain;

import com.tempo.challenge.calculation_service.domain.exception.TraceabilityException;
import com.tempo.challenge.calculation_service.domain.model.Calculation;
import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import com.tempo.challenge.calculation_service.domain.service.CalculationService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculationServiceTest {

    @Test
    void given_percentageProvided_when_calculate_then_returnCalculationWithResult() {
        // Given
        PercentageRepository mockPort = mock(PercentageRepository.class);
        when(mockPort.getCurrentPercentage()).thenReturn(Mono.just(new BigDecimal("10"))); // 10%

        CalculationService service = new CalculationService(mockPort);

        // When & Then
        StepVerifier.create(service.calculate(new BigDecimal("100"), new BigDecimal("50")))
                .assertNext(result -> {
                    assertNotNull(result);
                    assertEquals(new BigDecimal("165.00"), result.getResult().setScale(2));
                })
                .verifyComplete();
    }

    @Test
    void given_exceptionFromPort_when_calculate_then_throwTraceabilityException() {
        // Given
        PercentageRepository mockPort = mock(PercentageRepository.class);
        when(mockPort.getCurrentPercentage()).thenReturn(Mono.error(new RuntimeException("external error")));

        CalculationService service = new CalculationService(mockPort);

        // When / Then
        StepVerifier.create(service.calculate(new BigDecimal("10"), new BigDecimal("10")))
                .expectError(TraceabilityException.class)
                .verify();
    }


}
