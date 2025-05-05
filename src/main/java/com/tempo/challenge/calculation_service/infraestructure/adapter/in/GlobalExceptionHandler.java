package com.tempo.challenge.calculation_service.infraestructure.adapter.in;

import com.tempo.challenge.calculation_service.infraestructure.adapter.in.dto.ServerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejar errores de cliente (400)
    @ExceptionHandler({MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class, IllegalArgumentException.class})
    public ResponseEntity<ServerErrorResponse> handleBadRequest(Exception ex) {
        ServerErrorResponse response = ServerErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Invalid request parameters: please check num1 or num2 ")

                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Manejar errores del servidor (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServerErrorResponse> handleInternalServerError(Exception ex) {
        ServerErrorResponse response = ServerErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An unexpected error occurred while processing the request")
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}