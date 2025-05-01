package com.tempo.challenge.calculation_service.domain;

import com.tempo.challenge.calculation_service.domain.exception.TraceabilityException;
import com.tempo.challenge.calculation_service.domain.model.Calculation;
import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import com.tempo.challenge.calculation_service.domain.service.CalculationService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculationServiceTest {

    @Test
    void given_percentageProvided_when_calculate_then_returnCalculationWithResult() {

        // Given
        PercentageRepository mockPort = mock(PercentageRepository.class);
        when(mockPort.getCurrentPercentage()).thenReturn(new BigDecimal("10"));

        CalculationService service = new CalculationService(mockPort);

        // When
        Calculation result = service.calculate(new BigDecimal("100"), new BigDecimal("50"));

        // Then
        assertNotNull(result);
        assertEquals(new BigDecimal("165"), result.getResult());
    }

    @Test
    void given_exceptionFromPort_when_calculate_then_throwTraceabilityException() {
        // Given
        PercentageRepository mockPort = mock(PercentageRepository.class);
        when(mockPort.getCurrentPercentage()).thenThrow(new RuntimeException("external error"));

        CalculationService service = new CalculationService(mockPort);

        // When / Then
        assertThrows(TraceabilityException.class, () ->
                service.calculate(new BigDecimal("10"), new BigDecimal("10")));
    }


}
