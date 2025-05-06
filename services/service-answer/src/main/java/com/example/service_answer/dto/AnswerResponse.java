package com.example.service_answer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse {
    private Integer id;
    private Integer userId;
    private Integer questionId;
    private String answer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
