package com.example.service_quizz.service;

import com.example.service_quizz.model.Quiz;
import com.example.service_quizz.dto.QuizDTO;
import com.example.service_quizz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    // getallquiz
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();

    }


    //get quiz by id
    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }


    //create quiz
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    //updatequiz
    public boolean updateQuiz(Long id, QuizDTO quizDetails) {
        Optional<Quiz> quizoptional = quizRepository.findById(id);

        if (quizoptional.isPresent()) {
            Quiz quiz = quizoptional.get();
            quiz.setTitle(quizDetails.getTitle());
            quiz.setDuration(quizDetails.getDuration());
            quiz.setDescription(quizDetails.getDescription());
            quizRepository.save(quiz);
        }
        return true;
    }


    //deleteuser

    public boolean deleteQuiz(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);

        if (quiz.isPresent()) {
            quizRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
