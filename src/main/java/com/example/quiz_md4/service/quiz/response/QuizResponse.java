package com.example.quiz_md4.service.quiz.response;

import com.example.quiz_md4.model.Answer;
import com.example.quiz_md4.service.answer.response.AnswerResponse;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {
    private String id;
    private String question;
    private List<AnswerResponse> answers;
}
