package com.rajat.testgeek.service;

import java.util.Set;

import com.rajat.testgeek.models.Exam.Category;

public interface CategoryService {
    public Category addCategory(Category category) throws Exception;
    public Category updateCategory(Category category, Long categoryId) throws Exception;
    public Set<Category> getCategories();
    public Category getCategory(String title);
    public void deleteCategory(Long categoryId);
}
