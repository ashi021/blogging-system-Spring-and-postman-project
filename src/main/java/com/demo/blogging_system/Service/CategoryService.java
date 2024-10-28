package com.demo.blogging_system.Service;

import com.demo.blogging_system.Entities.Category;

import java.util.List;

// This is an interface for Category service operations
public interface CategoryService {
    
    // Method to create a new category
    Category createCategory(Category category);
    
    // Method to update an existing category by its ID
    Category updateCategory(Category category, Long categoryId);
    
    // Method to get a category by its ID
    Category getCategoryById(Long categoryId);
    
    // Method to get a list of all categories
    List<Category> getAllCategories();
    
    // Method to delete a category by its ID
    void deleteCategory(Long categoryId);
}
