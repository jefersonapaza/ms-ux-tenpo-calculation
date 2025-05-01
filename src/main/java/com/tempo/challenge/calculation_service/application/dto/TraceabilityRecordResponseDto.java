package com.tempo.challenge.calculation_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-29
 * Role: Software Engineer
 * <p>
 * Data Transfer Object used to return traceability information of a calculation.
 */

@Data
@Builder
@AllArgsConstructor
public class TraceabilityRecordResponseDto {
    private  BigDecimal num1;
    private  BigDecimal num2;
    private  BigDecimal percentageApplied;
    private  BigDecimal result;
    private  LocalDateTime timestamp;
}
