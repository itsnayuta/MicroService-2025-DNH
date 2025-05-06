package com.example.service_answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.service_answer.models.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByUserId(Integer userId);
    List<Answer> findByQuestionId(Integer questionId);
    List<Answer> findByAnswerContainingIgnoreCase(String keyword);
}