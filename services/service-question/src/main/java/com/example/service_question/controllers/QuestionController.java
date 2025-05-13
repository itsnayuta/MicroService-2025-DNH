package com.example.service_question.controllers;

import com.example.service_question.dto.QuestionRequest;
import com.example.service_question.dto.QuestionResponse;
import com.example.service_question.service.QuestionService;
import com.example.service_question.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    // Create question - only for ADMIN
    @PostMapping
    public ResponseEntity<?> createQuestion(
            @Valid @RequestBody QuestionRequest questionRequest,
            HttpServletRequest request) {
        
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            String roleUser = JWTUtils.extractRole(token.substring(7));
            
            if (roleUser.equals("ADMIN")) {
                QuestionResponse createdQuestion = questionService.createQuestion(questionRequest);
                return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOWED");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    // Get questions by quiz ID - available for both ADMIN and USER roles
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsByQuizId(
            @PathVariable Integer quizId,
            HttpServletRequest request) {
        
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            List<QuestionResponse> questions = questionService.getQuestionsByQuizId(quizId);
            return ResponseEntity.ok(questions);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    // Get all questions - only for ADMIN
    @GetMapping
    public ResponseEntity<?> getAllQuestions(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            String roleUser = JWTUtils.extractRole(token.substring(7));
            
            if (roleUser.equals("ADMIN")) {
                List<QuestionResponse> questions = questionService.getAllQuestions();
                return ResponseEntity.ok(questions);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOWED");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    // Get question by ID - available for both ADMIN and USER roles
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(
            @PathVariable Integer id,
            HttpServletRequest request) {
        
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            QuestionResponse question = questionService.getQuestionById(id);
            return ResponseEntity.ok(question);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    // Search questions - only for ADMIN
    @GetMapping("/search")
    public ResponseEntity<?> searchQuestions(
            @RequestParam String keyword,
            HttpServletRequest request) {
        
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            String roleUser = JWTUtils.extractRole(token.substring(7));
            
            if (roleUser.equals("ADMIN")) {
                List<QuestionResponse> questions = questionService.searchQuestions(keyword);
                return ResponseEntity.ok(questions);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOWED");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    // Update question - only for ADMIN
    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(
            @PathVariable Integer id,
            @Valid @RequestBody QuestionRequest questionRequest,
            HttpServletRequest request) {
        
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            String roleUser = JWTUtils.extractRole(token.substring(7));
            
            if (roleUser.equals("ADMIN")) {
                QuestionResponse updatedQuestion = questionService.updateQuestion(id, questionRequest);
                return ResponseEntity.ok(updatedQuestion);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOWED");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    // Delete question - only for ADMIN
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(
            @PathVariable Integer id,
            HttpServletRequest request) {
        
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            String roleUser = JWTUtils.extractRole(token.substring(7));
            
            if (roleUser.equals("ADMIN")) {
                questionService.deleteQuestion(id);
                return ResponseEntity.status(HttpStatus.OK).body("DELETED QUESTION SUCCESSFULLY");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOWED");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }
}