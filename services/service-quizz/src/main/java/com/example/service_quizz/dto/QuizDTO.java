package com.example.service_quizz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private String title;
    private int duration;  // Thời gian làm bài (phút)
    private String description;
}
