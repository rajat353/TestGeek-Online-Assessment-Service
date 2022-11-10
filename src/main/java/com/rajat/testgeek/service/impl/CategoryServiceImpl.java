package com.rajat.testgeek.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajat.testgeek.models.Exam.Category;
import com.rajat.testgeek.repository.CategoryRepository;
import com.rajat.testgeek.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) throws Exception {
        Category insertCategory= this.categoryRepository.findByTitle(category.getTitle());
        
        if(insertCategory!=null){
            System.out.println("Sorry!! Category  " + insertCategory.getTitle() + "  already exist.");
            throw new Exception("Category Already Exist!!");
        }else{
            categoryRepository.save(category);
        }
        return category;
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) throws Exception {

        Category updateCategory= this.categoryRepository.findById(categoryId).orElse(null);
        
        if(updateCategory==null){
            System.out.println("Sorry!! Category  " + category.getTitle() + "  does not exist.");
            throw new Exception("Category does not exist!!");
        }else{
            category.setCategoryId(categoryId);
            this.categoryRepository.save(category);
        }
        return category;
    }

    @Override
    public Set<Category> getCategories() {
        return new HashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(String title) {
        return this.categoryRepository.findByTitle(title);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }
    
    
}
