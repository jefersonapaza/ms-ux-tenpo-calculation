package com.tempo.challenge.calculation_service.infraestructure.adapter.in.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ServerErrorResponse {
    private LocalDateTime timestamp;
    private int code;
    private String message;
}