package com.example.quiz_md4.service.quiz;

import com.example.quiz_md4.model.Quiz;
import com.example.quiz_md4.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    public Page<Quiz> findAll(Pageable pageable){
        return  quizRepository.findAll(pageable);
    }
}
