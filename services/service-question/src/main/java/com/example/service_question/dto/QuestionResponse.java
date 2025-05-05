package com.example.service_question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private Integer id;
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Integer correctOption;
    private Integer quizId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getCorrectAnswerText() {
        switch (correctOption) {
            case 1: return option1;
            case 2: return option2;
            case 3: return option3;
            case 4: return option4;
            default: return null;
        }
    }
}