package com.tempo.challenge.calculation_service.infraestructure.adapter.out;

import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import com.tempo.challenge.calculation_service.infraestructure.config.PercentageResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Repository
public class PercentageRepositoryImpl implements PercentageRepository {

    private final WebClient.Builder webClientBuilder;

    @Value("${percentage.service.url}")
    private String percentageServiceUrl;

    @Override
    public Mono<BigDecimal> getCurrentPercentage() {
        String url = percentageServiceUrl + "/percentage";

        return webClientBuilder
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(PercentageResponse.class)
                .map(response -> BigDecimal.valueOf(response.getPercentage()))
                .switchIfEmpty(Mono.error(new RuntimeException("No se recibió respuesta del servicio externo")));
    }
}
