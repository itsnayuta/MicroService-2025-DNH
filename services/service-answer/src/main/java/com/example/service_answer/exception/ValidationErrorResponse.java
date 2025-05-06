package com.example.service_answer.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Error response structure for validation errors.
 * Extends the standard ErrorResponse with field-specific error details.
 */
@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse {
    private Map<String, String> errors;
    
    public ValidationErrorResponse(
            LocalDateTime timestamp,
            int status,
            String error,
            String message,
            String path,
            Map<String, String> errors) {
        super(timestamp, status, error, message, path);
        this.errors = errors;
    }
}
