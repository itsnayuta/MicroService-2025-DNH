package com.example.service_question.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class để hiển thị chi tiết lỗi validation
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
