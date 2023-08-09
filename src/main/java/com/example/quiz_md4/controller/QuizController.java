package com.example.quiz_md4.controller;

import com.example.quiz_md4.model.enums.EType;
import com.example.quiz_md4.service.quiz.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;
    @GetMapping
    public ModelAndView home(Pageable pageable){
        ModelAndView view = new ModelAndView("home");
        view.addObject("quizzes", quizService.findAll(pageable));
        return view;
    }

}
