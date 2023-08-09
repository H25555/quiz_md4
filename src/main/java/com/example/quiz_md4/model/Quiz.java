package com.example.quiz_md4.model;

import com.example.quiz_md4.model.enums.EType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @OneToMany
    private List<Answer> answers;
    @Enumerated(EnumType.STRING)
    private EType type;

}
