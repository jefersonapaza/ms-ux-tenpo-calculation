package com.tempo.challenge.calculation_service.application.config;

import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import com.tempo.challenge.calculation_service.domain.service.CalculationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculationServiceConfig {

    @Bean
    public CalculationService calculationService(PercentageRepository percentageRepository) {
        return new CalculationService(percentageRepository);
    }
}