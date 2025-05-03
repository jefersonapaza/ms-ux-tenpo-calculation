package com.tempo.challenge.calculation_service.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${percentage.service.url}")
    private String percentageServiceUrl;

    @Bean
    public WebClient percentageWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(percentageServiceUrl)
                .build();
    }
}