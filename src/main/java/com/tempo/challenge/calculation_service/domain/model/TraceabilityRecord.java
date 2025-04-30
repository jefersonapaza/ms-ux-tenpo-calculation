package com.tempo.challenge.calculation_service.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-26
 * Role: Software Engineer
 * <p>
 * Domain entity used for recording the traceability of each calculation operation,
 * storing relevant information for auditing and monitoring purposes.
 */
public class TraceabilityRecord {

  private final BigDecimal num1;
  private final BigDecimal num2;
  private final BigDecimal percentageApplied;
  private final BigDecimal result;
  private final LocalDateTime timestamp;

  public TraceabilityRecord(BigDecimal num1, BigDecimal num2, BigDecimal percentageApplied, BigDecimal result, LocalDateTime timestamp) {
    this.num1 = num1;
    this.num2 = num2;
    this.percentageApplied = percentageApplied;
    this.result = result;
    this.timestamp = timestamp;
  }

  public BigDecimal getNum1() {
    return num1;
  }

  public BigDecimal getNum2() {
    return num2;
  }

  public BigDecimal getPercentageApplied() {
    return percentageApplied;
  }

  public BigDecimal getResult() {
    return result;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
