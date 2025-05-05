package com.tempo.challenge.calculation_service.infraestructure.adapter.in.dto;

import java.math.BigDecimal;

public record CalculateAmountRequest(BigDecimal num1, BigDecimal num2) {}
