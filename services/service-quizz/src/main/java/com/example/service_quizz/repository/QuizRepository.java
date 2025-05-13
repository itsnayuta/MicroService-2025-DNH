package com.example.service_quizz.repository;

import com.example.service_quizz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // Có thể thêm các truy vấn tùy chỉnh nếu cần
}
