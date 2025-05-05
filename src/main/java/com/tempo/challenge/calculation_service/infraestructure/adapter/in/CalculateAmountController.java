package com.tempo.challenge.calculation_service.infraestructure.adapter.in;

import com.tempo.challenge.calculation_service.application.dto.TraceabilityRecordResponseDto;
import com.tempo.challenge.calculation_service.application.usecase.PerformCalculationUseCase;
import com.tempo.challenge.calculation_service.infraestructure.adapter.in.dto.CalculateAmountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/calculate")
@RequiredArgsConstructor
public class CalculateAmountController {

    private final PerformCalculationUseCase performCalculationUseCase;

    @PostMapping
    public Mono<ResponseEntity<TraceabilityRecordResponseDto>> calculate(@RequestBody CalculateAmountRequest request) {
        return performCalculationUseCase.execute(request.num1(), request.num2())
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build()));
    }
}