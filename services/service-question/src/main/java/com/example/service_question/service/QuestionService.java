package com.example.service_question.service;

import com.example.service_question.dto.QuestionRequest;
import com.example.service_question.dto.QuestionResponse;
import com.example.service_question.exception.ResourceNotFoundException;
import com.example.service_question.models.Question;
import com.example.service_question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    
    private final QuestionRepository questionRepository;
    
    public QuestionResponse createQuestion(QuestionRequest questionRequest) {
        Question question = Question.builder()
                .questionText(questionRequest.getQuestionText())
                .option1(questionRequest.getOption1())
                .option2(questionRequest.getOption2())
                .option3(questionRequest.getOption3())
                .option4(questionRequest.getOption4())
                .correctOption(questionRequest.getCorrectOption())
                .quizId(questionRequest.getQuizId())
                .build();
        
        Question savedQuestion = questionRepository.save(question);
        return mapToQuestionResponse(savedQuestion);
    }

    public List<QuestionResponse> getQuestionsByQuizId(Integer quizId) {
        return questionRepository.findByQuizId(quizId).stream()
                .map(this::mapToQuestionResponse)
                .collect(Collectors.toList());
    }

    public List<QuestionResponse> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(this::mapToQuestionResponse)
                .collect(Collectors.toList());
    }

    public QuestionResponse getQuestionById(Integer id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
        return mapToQuestionResponse(question);
    }

    public List<QuestionResponse> searchQuestions(String keyword) {
        return questionRepository.findByQuestionTextContainingIgnoreCase(keyword).stream()
                .map(this::mapToQuestionResponse)
                .collect(Collectors.toList());
    }

    public QuestionResponse updateQuestion(Integer id, QuestionRequest questionRequest) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
        
        question.setQuestionText(questionRequest.getQuestionText());
        question.setOption1(questionRequest.getOption1());
        question.setOption2(questionRequest.getOption2());
        question.setOption3(questionRequest.getOption3());
        question.setOption4(questionRequest.getOption4());
        question.setCorrectOption(questionRequest.getCorrectOption());
        question.setQuizId(questionRequest.getQuizId());
        
        Question updatedQuestion = questionRepository.save(question);
        return mapToQuestionResponse(updatedQuestion);
    }

    public void deleteQuestion(Integer id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
        questionRepository.delete(question);
    }

    private QuestionResponse mapToQuestionResponse(Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .questionText(question.getQuestionText())
                .option1(question.getOption1())
                .option2(question.getOption2())
                .option3(question.getOption3())
                .option4(question.getOption4())
                .correctOption(question.getCorrectOption())
                .quizId(question.getQuizId())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
    }
}