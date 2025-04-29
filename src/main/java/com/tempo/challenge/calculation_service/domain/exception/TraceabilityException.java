package com.tempo.challenge.calculation_service.domain.exception;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-29
 * Role: Software Engineer
 * <p>
 * Exception thrown when an error occurs related to the traceability recording process.
 */
public class TraceabilityException extends RuntimeException {

    public TraceabilityException(String message) {
        super(message);
    }

    public TraceabilityException(String message, Throwable cause) {
        super(message, cause);
    }
}
