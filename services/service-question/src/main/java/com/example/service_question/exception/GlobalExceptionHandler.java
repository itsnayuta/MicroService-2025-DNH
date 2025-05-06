package com.example.service_question.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Xử lý tập trung các exception trong toàn bộ ứng dụng
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Xử lý ResourceNotFoundException
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFound(
            ResourceNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    /**
     * Xử lý BadRequestException
     */
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequest(
            BadRequestException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    /**
     * Xử lý lỗi validation từ @Valid annotation
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, 
            HttpHeaders headers, 
            HttpStatusCode status,
            WebRequest request) {
            
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage("Validation error");
        
        // Thêm các lỗi validation vào subErrors
        @SuppressWarnings("unused")
        List<ApiSubError> subErrors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            Object rejectedValue = ((FieldError) error).getRejectedValue();
            ApiValidationError validationError = new ApiValidationError(
                    ex.getBindingResult().getObjectName(),
                    fieldName,
                    rejectedValue,
                    errorMessage
            );
            apiError.addSubError(validationError);
        });
        
        return buildResponseEntity(apiError);
    }

    /**
     * Xử lý ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex) {
            
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage("Validation error");
        
        ex.getConstraintViolations().forEach(violation -> {
            ApiValidationError validationError = new ApiValidationError(
                    violation.getRootBeanClass().getName(),
                    violation.getPropertyPath().toString(),
                    violation.getInvalidValue(),
                    violation.getMessage()
            );
            apiError.addSubError(validationError);
        });
        
        return buildResponseEntity(apiError);
    }

    /**
     * Xử lý tất cả các exception khác
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(
            Exception ex, WebRequest request) {
            
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR, 
                "Internal Server Error", 
                ex
        );
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}