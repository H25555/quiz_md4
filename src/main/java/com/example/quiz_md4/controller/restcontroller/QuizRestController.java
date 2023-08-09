package com.example.quiz_md4.controller.restcontroller;

import com.example.quiz_md4.model.Quiz;
import com.example.quiz_md4.service.quiz.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
@AllArgsConstructor
public class QuizRestController {
    private final QuizService quizService;
    @GetMapping
    public Page<Quiz> findAll(Pageable pageable){
        return quizService.findAll(pageable);
    }
}
