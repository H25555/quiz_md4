package com.example.quiz_md4.repository;

import com.example.quiz_md4.model.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    @Override
    Page<Quiz> findAll(Pageable pageable);
}
