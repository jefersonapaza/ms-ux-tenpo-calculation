package com.tempo.challenge.calculation_service.domain.service;

import com.tempo.challenge.calculation_service.domain.exception.TraceabilityException;
import com.tempo.challenge.calculation_service.domain.model.Calculation;
import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-28
 * Role: Software Engineer
 * <p>
 * Domain service responsible for orchestrating the calculation process.
 * It fetches the current percentage from an external service through PercentagePort
 * and delegates the calculation logic to the Calculation entity.
 */

public class CalculationService {
    private final PercentageRepository percentageRepository;

    public CalculationService(PercentageRepository percentageRepository) {
        this.percentageRepository = percentageRepository;
    }

    public Mono<Calculation> calculate(BigDecimal num1, BigDecimal num2) {

        return percentageRepository.getCurrentPercentage()
                .switchIfEmpty(Mono.error(new TraceabilityException("No cached percentage available and external service failed.")))
                .map(percentage -> {
                    Calculation calculation = new Calculation(num1, num2, percentage);
                    calculation.calculateResult();
                    return calculation;
                })
                .onErrorResume(e -> Mono.error(new TraceabilityException("Error retrieving percentage from external service.", e)));
    }
}
