package com.example.service_answer.controller;

import com.example.service_answer.dto.AnswerRequest;
import com.example.service_answer.dto.AnswerResponse;
import com.example.service_answer.service.AnswerService;
import com.example.service_answer.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> createAnswer(@Valid @RequestBody AnswerRequest answerRequest, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            AnswerResponse response = answerService.createAnswer(answerRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<?> getAnswersByUserId(@PathVariable Integer userId, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            List<AnswerResponse> answers = answerService.getAnswersByUserId(userId);
            return ResponseEntity.ok(answers);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    @GetMapping
    public ResponseEntity<?> getAllAnswers(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            String role = JWTUtils.extractRole(token.substring(7));
            
            if (role.equals("ADMIN")) {
                List<AnswerResponse> answers = answerService.getAllAnswers();
                return ResponseEntity.ok(answers);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnswerById(@PathVariable Integer id, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            AnswerResponse answer = answerService.getAnswerById(id);
            return ResponseEntity.ok(answer);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<?> getAnswersByQuestionId(@PathVariable Integer questionId, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            List<AnswerResponse> answers = answerService.getAnswersByQuestionId(questionId);
            return ResponseEntity.ok(answers);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchAnswers(@RequestParam String keyword, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            String role = JWTUtils.extractRole(token.substring(7));

            if (role.equals("ADMIN")) {
                List<AnswerResponse> answers = answerService.searchAnswers(keyword);
                return ResponseEntity.ok(answers);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnswer(@PathVariable Integer id, @Valid @RequestBody AnswerRequest answerRequest, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {


            AnswerResponse updatedAnswer = answerService.updateAnswer(id, answerRequest);
            return ResponseEntity.ok(updatedAnswer);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Integer id, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (JWTUtils.isTokenValid(token)) {
            String role = JWTUtils.extractRole(token.substring(7));
            
            if (role.equals("ADMIN")) {
                answerService.deleteAnswer(id);
                return ResponseEntity.noContent().build();
            } else {             
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }
}