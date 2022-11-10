package com.rajat.testgeek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rajat.testgeek.models.Exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByTitle(String title);

}
