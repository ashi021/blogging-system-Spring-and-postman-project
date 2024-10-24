package com.demo.blogging_system.Service;

import com.demo.blogging_system.Entities.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category, Long categoryId);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();
    void deleteCategory(Long categoryId);
}

