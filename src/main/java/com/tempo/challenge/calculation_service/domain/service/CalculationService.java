package com.tempo.challenge.calculation_service.domain.service;

import com.tempo.challenge.calculation_service.domain.model.Calculation;
import com.tempo.challenge.calculation_service.domain.port.PercentagePort;

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
    private final PercentagePort percentagePort;

    public CalculationService(PercentagePort percentagePort) {
        this.percentagePort = percentagePort;
    }

    public Calculation calculate(BigDecimal num1, BigDecimal num2) {
        BigDecimal percentage = percentagePort.getCurrentPercentage();
        Calculation calculation = new Calculation(num1, num2, percentage);
        calculation.calculateResult(); // la lógica vive en la entidad
        return calculation;
    }
}
