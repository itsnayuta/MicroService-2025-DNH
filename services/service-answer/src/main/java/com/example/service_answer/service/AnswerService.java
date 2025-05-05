package com.example.service_answer.service;

import com.example.service_answer.dto.AnswerRequest;
import com.example.service_answer.dto.AnswerResponse;
import com.example.service_answer.exception.ResourceNotFoundException;
import com.example.service_answer.models.Answer;
import com.example.service_answer.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {
    
    private final AnswerRepository answerRepository;

    public AnswerResponse createAnswer(AnswerRequest answerRequest) {
        Answer answer = Answer.builder()
                .userId(answerRequest.getUserId())
                .questionId(answerRequest.getQuestionId())
                .answer(answerRequest.getAnswer())
                .build();
        
        Answer savedAnswer = answerRepository.save(answer);
        return mapToAnswerResponse(savedAnswer);
    }

    public List<AnswerResponse> getAnswersByUserId(Integer userId) {
        return answerRepository.findByUserId(userId).stream()
                .map(this::mapToAnswerResponse)
                .collect(Collectors.toList());
    }

    public List<AnswerResponse> getAllAnswers() {
        return answerRepository.findAll().stream()
                .map(this::mapToAnswerResponse)
                .collect(Collectors.toList());
    }

    public AnswerResponse getAnswerById(Integer id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answer", "id", id));
        return mapToAnswerResponse(answer);
    }

    public List<AnswerResponse> getAnswersByQuestionId(Integer questionId) {
        return answerRepository.findByQuestionId(questionId).stream()
                .map(this::mapToAnswerResponse)
                .collect(Collectors.toList());
    }

    public List<AnswerResponse> searchAnswers(String keyword) {
        return answerRepository.findByAnswerContainingIgnoreCase(keyword).stream()
                .map(this::mapToAnswerResponse)
                .collect(Collectors.toList());
    }

    public AnswerResponse updateAnswer(Integer id, AnswerRequest answerRequest) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answer", "id", id));
        
        answer.setUserId(answerRequest.getUserId());
        answer.setQuestionId(answerRequest.getQuestionId());
        answer.setAnswer(answerRequest.getAnswer());
        
        Answer updatedAnswer = answerRepository.save(answer);
        return mapToAnswerResponse(updatedAnswer);
    }

    public void deleteAnswer(Integer id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answer", "id", id));
        answerRepository.delete(answer);
    }

    private AnswerResponse mapToAnswerResponse(Answer answer) {
        return AnswerResponse.builder()
                .id(answer.getId())
                .userId(answer.getUserId())
                .questionId(answer.getQuestionId())
                .answer(answer.getAnswer())
                .createdAt(answer.getCreatedAt())
                .updatedAt(answer.getUpdatedAt())
                .build();
    }
}