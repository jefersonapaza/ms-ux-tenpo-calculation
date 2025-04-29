package com.tempo.challenge.calculation_service.domain.exception;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-29
 * Role: Software Engineer
 * <p>
 * Exception thrown when an invalid percentage is provided for a calculation.
 */
public class InvalidPercentageException extends RuntimeException {
    public InvalidPercentageException(String message) {
        super(message);
    }
}
