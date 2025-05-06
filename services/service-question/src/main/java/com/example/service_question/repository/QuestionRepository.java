package com.example.service_question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.service_question.models.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByQuizId(Integer quizId);
    List<Question> findByQuestionTextContainingIgnoreCase(String keyword);
    List<Question> findByCorrectOption(Integer correctOption);
    List<Question> findByQuizIdAndQuestionTextContainingIgnoreCase(Integer quizId, String keyword);
}
