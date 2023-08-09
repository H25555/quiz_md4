package com.example.quiz_md4.repository;

import com.example.quiz_md4.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
