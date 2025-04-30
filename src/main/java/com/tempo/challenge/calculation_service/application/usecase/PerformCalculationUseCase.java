package com.tempo.challenge.calculation_service.application.usecase;

import com.tempo.challenge.calculation_service.domain.model.Calculation;
import com.tempo.challenge.calculation_service.domain.model.TraceabilityRecord;
import com.tempo.challenge.calculation_service.domain.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-29
 * Role: Software Engineer
 * <p>
 * Application service (use case) responsible for coordinating the calculation
 * and traceability recording process.
 */

@Service
@RequiredArgsConstructor
public class PerformCalculationUseCase {

    private final CalculationService calculationService;

    public PerformCalculationUseCase(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public TraceabilityRecord execute(BigDecimal num1, BigDecimal num2) {
        Calculation calculation = calculationService.calculate(num1, num2);

        return new TraceabilityRecord(
                calculation.getNum1(),
                calculation.getNum2(),
                calculation.getPercentage(),
                calculation.getResult(),
                LocalDateTime.now()
        );
    }

}
