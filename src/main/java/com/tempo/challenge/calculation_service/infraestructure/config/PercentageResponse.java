package com.tempo.challenge.calculation_service.infraestructure.config;

import java.math.BigDecimal;

public class PercentageResponse {
    private BigDecimal percentage;

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}