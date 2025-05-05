package com.example.service_answer.controllers;

import com.example.service_answer.dto.AnswerRequest;
import com.example.service_answer.dto.AnswerResponse;
import com.example.service_answer.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerResponse> createAnswer(@Valid @RequestBody AnswerRequest answerRequest) {
        AnswerResponse response = answerService.createAnswer(answerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<AnswerResponse>> getAnswersByUserId(@PathVariable Integer userId) {
        List<AnswerResponse> answers = answerService.getAnswersByUserId(userId);
        return ResponseEntity.ok(answers);
    }

    @GetMapping
    public ResponseEntity<List<AnswerResponse>> getAllAnswers() {
        List<AnswerResponse> answers = answerService.getAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponse> getAnswerById(@PathVariable Integer id) {
        AnswerResponse answer = answerService.getAnswerById(id);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<AnswerResponse>> getAnswersByQuestionId(@PathVariable Integer questionId) {
        List<AnswerResponse> answers = answerService.getAnswersByQuestionId(questionId);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnswerResponse>> searchAnswers(@RequestParam String keyword) {
        List<AnswerResponse> answers = answerService.searchAnswers(keyword);
        return ResponseEntity.ok(answers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponse> updateAnswer(@PathVariable Integer id, @Valid @RequestBody AnswerRequest answerRequest) {
        AnswerResponse updatedAnswer = answerService.updateAnswer(id, answerRequest);
        return ResponseEntity.ok(updatedAnswer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Integer id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}