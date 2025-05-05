package com.example.service_question.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "question_text")
    @NotBlank(message = "Question text is required")
    private String questionText;
    
    @Column(name = "option_1")
    @NotBlank(message = "Option 1 is required")
    private String option1;
    
    @Column(name = "option_2")
    @NotBlank(message = "Option 2 is required")
    private String option2;
    
    @Column(name = "option_3")
    @NotBlank(message = "Option 3 is required")
    private String option3;
    
    @Column(name = "option_4")
    @NotBlank(message = "Option 4 is required")
    private String option4;
    
    @Column(name = "correct_option")
    @NotNull(message = "Correct option is required")
    private Integer correctOption;
    
    @Column(name = "quiz_id")
    @NotNull(message = "Quiz ID is required")
    private Integer quizId;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Transient
    public String[] getAllOptions() {
        return new String[]{option1, option2, option3, option4};
    }
    
    @Transient
    public String getCorrectAnswerText() {
        switch (correctOption) {
            case 1: return option1;
            case 2: return option2;
            case 3: return option3;
            case 4: return option4;
            default: return null;
        }
    }
    
    @Transient
    public boolean isCorrectOption(int optionNumber) {
        return optionNumber == correctOption;
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
