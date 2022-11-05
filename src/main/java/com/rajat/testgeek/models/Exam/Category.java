package com.rajat.testgeek.models.Exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
    @JsonIgnore
    private Set<Quiz> quizes = new LinkedHashSet<>();

    public Category() {
    }

    public Category(Long categoryId, String title, String description) {
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
    }

}
