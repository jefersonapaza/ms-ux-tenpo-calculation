package com.tempo.challenge.calculation_service.application;


import com.tempo.challenge.calculation_service.application.dto.TraceabilityRecordResponseDto;
import com.tempo.challenge.calculation_service.application.mapper.TraceabilityRecordMapper;
import com.tempo.challenge.calculation_service.application.usecase.PerformCalculationUseCase;
import com.tempo.challenge.calculation_service.domain.model.Calculation;
import com.tempo.challenge.calculation_service.domain.service.CalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PerformCalculationUseCaseTest {

    @Mock
    private CalculationService calculationService;

    @InjectMocks
    private PerformCalculationUseCase useCase;

    private final BigDecimal num1 = BigDecimal.valueOf(10);
    private final BigDecimal num2 = BigDecimal.valueOf(5);
    private final BigDecimal percentage = BigDecimal.valueOf(20);
    private final BigDecimal result = BigDecimal.valueOf(18);

    private Calculation calculation;

    @BeforeEach
    void setUp() {
        calculation = new Calculation(num1, num2, percentage);
        calculation.calculateResult();
    }

    @Test
    void given_validInputs_when_execute_then_returnTraceabilityRecordResponseDto() {
        // Arrange
        when(calculationService.calculate(num1, num2)).thenReturn(Mono.just(calculation));

        // Act & Assert
        StepVerifier.create(useCase.execute(num1, num2))
                .assertNext(response -> {
                    assertEquals(num1, response.getNum1());
                    assertEquals(num2, response.getNum2());
                    assertEquals(percentage, response.getPercentageApplied());
                    assertEquals(calculation.getResult(), response.getResult());
                    assertNotNull(response.getTimestamp());
                })
                .verifyComplete();

        verify(calculationService, times(1)).calculate(num1, num2);
    }


    @Test
    void given_serviceThrowsException_when_execute_then_propagateException() {
        // Arrange
        when(calculationService.calculate(num1, num2)).thenThrow(new RuntimeException("Calculation failed"));

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> useCase.execute(num1, num2));
        assertEquals("Calculation failed", exception.getMessage());

        verify(calculationService, times(1)).calculate(num1, num2);
    }

}
