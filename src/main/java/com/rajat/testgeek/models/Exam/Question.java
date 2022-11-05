package com.rajat.testgeek.models.Exam;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Question")
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionId;

    private String content;
    private String o1;
    private String o2;
    private String o3;
    private String o4;
    private String answer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

}
