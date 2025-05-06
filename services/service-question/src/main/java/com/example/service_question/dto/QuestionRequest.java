package com.example.service_question.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    
    @NotBlank(message = "Question text is required")
    private String questionText;
    
    @NotBlank(message = "Option 1 is required")
    private String option1;
    
    @NotBlank(message = "Option 2 is required")
    private String option2;
    
    @NotBlank(message = "Option 3 is required")
    private String option3;
    
    @NotBlank(message = "Option 4 is required")
    private String option4;
    
    @NotNull(message = "Correct option is required")
    private Integer correctOption;
    
    @NotNull(message = "Quiz ID is required")
    private Integer quizId;
}