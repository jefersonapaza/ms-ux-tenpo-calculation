package com.tempo.challenge.calculation_service.infraestructure.adapter.out;

import com.tempo.challenge.calculation_service.infraestructure.config.PercentageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;

@RequiredArgsConstructor
@Repository
public class ExternalPercentageClient {

    private final WebClient percentageWebClient;

    public Mono<BigDecimal> fetchPercentage() {

        return percentageWebClient
                .get()
                .retrieve()
                .bodyToMono(PercentageResponse.class)
                .map(PercentageResponse::getPercentage)
                .switchIfEmpty(Mono.error(new RuntimeException("No se recibió respuesta del servicio externo")));
    }

}