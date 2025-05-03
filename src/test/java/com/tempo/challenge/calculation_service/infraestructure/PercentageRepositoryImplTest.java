package com.tempo.challenge.calculation_service.infraestructure;

import com.tempo.challenge.calculation_service.infraestructure.adapter.out.PercentageRepositoryImpl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
class PercentageRepositoryImplTest {

    private MockWebServer mockWebServer;
    private PercentageRepositoryImpl percentageRepository;

    @BeforeEach
    void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        String baseUrl = mockWebServer.url("/").toString();

        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();

        percentageRepository = new PercentageRepositoryImpl(webClient);
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void given_validResponse_when_getCurrentPercentage_then_returnPercentage() {
        String mockBody = "{\"percentage\": 15.5}";
        mockWebServer.enqueue(new MockResponse()
                .setBody(mockBody)
                .addHeader("Content-Type", "application/json"));

        Mono<BigDecimal> result = percentageRepository.getCurrentPercentage();

        StepVerifier.create(result)
                .expectNext(new BigDecimal("15.5"))
                .verifyComplete();
    }
}
