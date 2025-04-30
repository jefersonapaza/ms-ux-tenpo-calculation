package com.tempo.challenge.calculation_service.domain;

import com.tempo.challenge.calculation_service.domain.model.TraceabilityRecord;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TraceabilityRecordTest {

    @Test
    void given_validInputs_when_createTraceabilityRecord_then_storeCorrectly() {

        // Given
        UUID id = UUID.randomUUID();
        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("15");
        BigDecimal percentage = new BigDecimal("20");
        BigDecimal result = new BigDecimal("30");
        LocalDateTime timestamp = LocalDateTime.now();

        // When
        TraceabilityRecord record = new TraceabilityRecord( num1, num2, percentage, result, timestamp);

        // Then
        assertEquals(num1, record.getNum1());
        assertEquals(num2, record.getNum2());
        assertEquals(percentage, record.getPercentageApplied());
        assertEquals(result, record.getResult());
        assertEquals(timestamp, record.getTimestamp());
    }
}
