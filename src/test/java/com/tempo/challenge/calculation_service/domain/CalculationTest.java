package com.tempo.challenge.calculation_service.domain;

import com.tempo.challenge.calculation_service.domain.exception.InvalidPercentageException;
import com.tempo.challenge.calculation_service.domain.model.Calculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculationTest {

    static Stream<Arguments> provideCalculationScenarios() {
        return Stream.of(
                Arguments.of("10", "20", "10", "33"),
                Arguments.of("100", "200", "50", "450"),
                Arguments.of("5.5", "4.5", "20", "12.0")
        );
    }

    @ParameterizedTest
    @MethodSource("provideCalculationScenarios")
    void given_validInputs_when_calculateResult_then_returnExpectedResult(
            String num1, String num2, String percentage, String expected
    ) {
        // Given
        Calculation calculation = new Calculation(
                new BigDecimal(num1),
                new BigDecimal(num2),
                new BigDecimal(percentage)
        );

        // When
        calculation.calculateResult();

        // Then
        assertEquals(new BigDecimal(expected), calculation.getResult());
    }

    @Test
    void given_invalidPercentage_when_calculateResult_then_throwInvalidPercentageException() {
        // Given
        Calculation calculation = new Calculation(
                new BigDecimal("10"),
                new BigDecimal("10"),
                new BigDecimal("200")
        );

        // When / Then
        assertThrows(InvalidPercentageException.class, calculation::calculateResult);
    }



}
