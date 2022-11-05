package com.rajat.testgeek.models.Exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Quiz")
@Getter
@Setter
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quizId;

    private String title;
    private String description;
    private String maxScore;
    private int numOfQuestions;
    private boolean isActive = false;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "quiz")
    @JsonIgnore
    private Set<Question> questions = new LinkedHashSet<>();

    public Quiz() {
    }

    public Quiz(Long quizId, String title, String description, String maxScore, int numOfQuestions, boolean active) {
        this.quizId = quizId;
        this.title = title;
        this.description = description;
        this.maxScore = maxScore;
        this.numOfQuestions = numOfQuestions;
        this.isActive = active;
    }

}
