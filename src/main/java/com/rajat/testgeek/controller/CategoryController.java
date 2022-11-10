package com.rajat.testgeek.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.testgeek.models.Exam.Category;
import com.rajat.testgeek.service.CategoryService;


@RestController
@RequestMapping("/exam")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryServiceImpl;

    @PostMapping("/category/")
    private Category addCategory(@RequestBody Category category) throws Exception{
        return categoryServiceImpl.addCategory(category);
    }

    @GetMapping("/category/{title}")
    private Category getCategory(@PathVariable("title") String title){
        return this.categoryServiceImpl.getCategory(title);
    }

    @GetMapping("/categories/")
    private Set<Category> getCategories(){
        return this.categoryServiceImpl.getCategories();
    }

    @PutMapping("/category/update/{categoryId}")
    private Category updateCategory(@RequestBody Category category, @PathVariable("categoryId") Long categoryId) throws Exception{
        return this.categoryServiceImpl.updateCategory(category, categoryId);
    }

    @DeleteMapping("/category/{categoryId}")
    private void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryServiceImpl.deleteCategory(categoryId);
    }
}
