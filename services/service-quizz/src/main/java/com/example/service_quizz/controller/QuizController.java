package com.example.service_quizz.controller;

import com.example.service_quizz.dto.QuizDTO;
import com.example.service_quizz.model.Quiz;
import com.example.service_quizz.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service_quizz.service.QuizService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/quizzes")
public class QuizController {



    @Autowired
    private QuizService quizService;

    // get all quiz
    @GetMapping
    public ResponseEntity<?> getAllQuizzes(HttpServletRequest request) {

        return ResponseEntity.ok(quizService.getAllQuizzes());

    }

    // get quiz from id
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuizById(@PathVariable Long id, HttpServletRequest request) {
        Optional<Quiz> quiz = quizService.getQuizById(id);
        if (quiz.isPresent()) {
            return ResponseEntity.ok(quiz.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quiz not found");



    }

    // create quiz only for admin
    @PostMapping
    public ResponseEntity<?> createQuiz(@RequestBody QuizDTO quizdto, HttpServletRequest request) {
       String token = request.getHeader("Authorization");

       String roleuser = JWTUtils.extractRole(token.substring(7));

       if (roleuser.equals("ADMIN")) {
           Quiz quiz = new Quiz();
           quiz.setTitle(quizdto.getTitle());
           quiz.setDuration(quizdto.getDuration());
           quiz.setDescription(quizdto.getDescription());
           quizService.createQuiz(quiz);

           return ResponseEntity.status(HttpStatus.CREATED).body(quiz);
       }
       else{
           return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
       }


    }

    // update quiz only for admin
    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuiz(@PathVariable Long id, @RequestBody QuizDTO quizdto, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String roleuser = JWTUtils.extractRole(token.substring(7));

        if (roleuser.equals("ADMIN")) {
           if(quizService.updateQuiz(id,quizdto)){
               return ResponseEntity.status(HttpStatus.CREATED).body("UPDATED");
           }
           else{
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
           }
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
        }

    }

    // delete quiz only for admin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Long id, HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        String roleuser = JWTUtils.extractRole(token.substring(7));

        if (roleuser.equals("ADMIN")) {
            if(quizService.deleteQuiz(id)){
                return ResponseEntity.status(HttpStatus.OK).body("DELETED");
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
            }
        }

        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT ALLOW");
        }
    }


}
